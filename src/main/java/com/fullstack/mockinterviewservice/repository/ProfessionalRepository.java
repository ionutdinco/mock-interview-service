package com.fullstack.mockinterviewservice.repository;

import com.fullstack.mockinterviewservice.entity.ProfessionalEntity;
import com.fullstack.mockinterviewservice.model.Professional;
import com.fullstack.mockinterviewservice.projections.ProfProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, String> {

    @Query( "SELECT new com.fullstack.mockinterviewservice.projections.ProfProjection(professional, professions.name) FROM ProfessionalEntity professional JOIN professional.professionEntities professions JOIN professions.domainEntity domain where domain.id=:domain"
    )
    List<ProfProjection> getByDomainIgnoreCase(String domain);
}
