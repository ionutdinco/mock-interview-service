package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.ProfessionEntity;
import com.fullstack.mockinterviewservice.entity.ProfessionalEntity;
import com.fullstack.mockinterviewservice.error.ProfessionEmptyException;
import com.fullstack.mockinterviewservice.model.Profession;
import com.fullstack.mockinterviewservice.model.Professional;
import com.fullstack.mockinterviewservice.projections.ProfProjection;
import com.fullstack.mockinterviewservice.repository.ProfessionRepository;
import com.fullstack.mockinterviewservice.repository.ProfessionalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class ProfessionalServiceImpl implements ProfessionalService{

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ProfessionRepository professionRepository;

    @Override
    public Profession addProfessional(Professional professional) throws ProfessionEmptyException {
        Optional<ProfessionalEntity> professionalOptional = professionalRepository.findById(professional.getEmail());
        Optional<ProfessionEntity> profession = professionRepository.findByNameIgnoreCase(professional.getProfession());
        if(professionalOptional.isPresent()){
            if (profession.isPresent()) {
                professionalOptional.get().getProfessionEntities().add(profession.get());
                professionalRepository.save(professionalOptional.get());
            }
            else throw new ProfessionEmptyException();

        }else {
            if (profession.isPresent()) {
                Set<ProfessionEntity> professionEntitySet = new HashSet<>();
                professionEntitySet.add(profession.get());
                ProfessionalEntity professionalEntity = ProfessionalEntity.builder()
                        .email(professional.getEmail())
                        .icon(professional.getIcon())
                        .name(professional.getName())
                        .professionEntities(professionEntitySet)
                        .build();
                professionalRepository.save(professionalEntity);
            }else throw new ProfessionEmptyException();
        }
        return Profession.builder()
                .id(profession.get().getProfessionId())
                .name(profession.get().getName())
                .build();
    }

    @Override
    public List<Profession> getProfessionsOfUser(String email) {
        Optional<ProfessionalEntity> professional = professionalRepository.findById(email);
        return professional.map(professionalEntity -> professionalEntity.getProfessionEntities().stream()
                .map(professionEntity -> Profession.builder()
                        .name(professionEntity.getName())
                        .id(professionEntity.getProfessionId())
                        .build())
                .toList()).orElse(null);
    }

    @Override
    public List<Professional> getProfessionals(String domain) {
        List<ProfProjection> profProjections = professionalRepository.getByDomainIgnoreCase(domain);
        return profProjections.stream().map(
                profProjection -> Professional.builder()
                        .email(profProjection.getProfessionalEntity().getEmail())
                        .name(profProjection.getProfessionalEntity().getName())
                        .icon(profProjection.getProfessionalEntity().getIcon())
                        .profession(profProjection.getProfession())
                        .build()

        ).toList();
    }
}
