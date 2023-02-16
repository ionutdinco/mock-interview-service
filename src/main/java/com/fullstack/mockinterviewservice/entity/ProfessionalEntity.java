package com.fullstack.mockinterviewservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessionalEntity {

    @Id
    private String email;
    private String icon;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "professional_profession_map",
            joinColumns = @JoinColumn(
                    name = "professional_id",
                    referencedColumnName = "email"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "profession_id",
                    referencedColumnName = "professionId"
            )
    )
    private Set<ProfessionEntity> professionEntities;
}
