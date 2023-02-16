package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.DomainEntity;
import com.fullstack.mockinterviewservice.error.DomainEmptyException;
import com.fullstack.mockinterviewservice.model.Domain;

import java.util.List;

public interface DomainService {
    Domain saveDomain(Domain domain);

    List<Domain> getDomains() throws DomainEmptyException;

    Integer getSize();
}
