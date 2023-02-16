package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.error.ProfessionEmptyException;
import com.fullstack.mockinterviewservice.model.Profession;
import com.fullstack.mockinterviewservice.model.Professional;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProfessionalService {
    Profession addProfessional(Professional professional) throws ProfessionEmptyException;

    List<Profession> getProfessionsOfUser(String email);

    List<Professional> getProfessionals(String domain);
}
