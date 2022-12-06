package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.DomainEntity;
import com.fullstack.mockinterviewservice.entity.ProfessionEntity;
import com.fullstack.mockinterviewservice.error.ProfessionAlreadyExistsException;
import com.fullstack.mockinterviewservice.repository.DomainRepository;
import com.fullstack.mockinterviewservice.repository.ProfessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProfessionServiceImpl implements ProfessionService{

    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private ProfessionRepository professionRepository;
    @Override
    public void saveProfession(String profession, String domain) throws ProfessionAlreadyExistsException {
        Optional<DomainEntity> domainEntity = domainRepository.findByNameIgnoreCase(domain);
        if (domainEntity.isPresent()){
            Optional<ProfessionEntity> professionEntity = professionRepository.findByNameIgnoreCase(profession);
            if (professionEntity.isPresent())
                throw new ProfessionAlreadyExistsException("Already exists");
            ProfessionEntity professionEntity1 = ProfessionEntity.builder()
                    .name(profession)
                    .domainEntity(domainEntity.get())
                    .build();
            professionEntity1 = professionRepository.save(professionEntity1);
        }else{
            DomainEntity _domainEntity = DomainEntity.builder()
                    .name(domain)
                    .build();
            _domainEntity = domainRepository.save(_domainEntity);
            ProfessionEntity professionEntity1 = ProfessionEntity.builder()
                    .name(profession)
                    .domainEntity(_domainEntity)
                    .build();
            professionEntity1 = professionRepository.save(professionEntity1);
        }
    }
}
