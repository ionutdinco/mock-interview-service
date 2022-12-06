package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.error.ProfessionAlreadyExistsException;
import com.fullstack.mockinterviewservice.model.Domain;

public interface ProfessionService {

    void saveProfession(String profession, String domainModel) throws ProfessionAlreadyExistsException;
}
