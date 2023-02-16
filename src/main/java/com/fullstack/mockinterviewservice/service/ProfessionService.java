package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.error.ProfessionAlreadyExistsException;
import com.fullstack.mockinterviewservice.model.Domain;
import com.fullstack.mockinterviewservice.model.Profession;

import java.util.List;

public interface ProfessionService {

    void saveProfession(String profession, String domainModel) throws ProfessionAlreadyExistsException;

    List<Profession> getProfessionsOfDomain(String domain);
}
