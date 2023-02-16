package com.fullstack.mockinterviewservice.projections;

import com.fullstack.mockinterviewservice.entity.ProfessionalEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfProjection implements Serializable {
    ProfessionalEntity professionalEntity;
    String profession;
}
