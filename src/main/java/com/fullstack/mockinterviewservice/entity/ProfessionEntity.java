package com.fullstack.mockinterviewservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professionId;
    private String name;

    @ManyToOne()
    @JoinColumn(
            name = "domain_id",
            referencedColumnName = "domainId"
    )
    private DomainEntity domainEntity;
}
