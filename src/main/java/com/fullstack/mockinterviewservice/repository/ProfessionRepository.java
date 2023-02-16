package com.fullstack.mockinterviewservice.repository;

import com.fullstack.mockinterviewservice.entity.ProfessionEntity;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessionRepository extends JpaRepository<ProfessionEntity, Long> {
    Optional<ProfessionEntity> findByNameIgnoreCase(String profession);

    @Query(value = "Select p.name, p.profession_id, p.domain_id from profession_entity as p join domain_entity as d on p.domain_id = d.domain_id where d.name = :name",
    nativeQuery = true)
    List<ProfessionEntity> findByDomain(@Param("name") String name);
}
