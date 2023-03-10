package com.fullstack.mockinterviewservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long domainId;

    @Column(unique = true,
            nullable = false)
    private String name;

    @OneToMany(mappedBy = "domainEntity",
            fetch = FetchType.LAZY ,
            cascade = CascadeType.REMOVE)
    private Set<ProfessionEntity> professionEntities;
}
