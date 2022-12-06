package com.fullstack.mockinterviewservice.repository;

import com.fullstack.mockinterviewservice.entity.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionRepository extends JpaRepository<ProfessionEntity, Long> {
    Optional<ProfessionEntity> findByNameIgnoreCase(String profession);
}
