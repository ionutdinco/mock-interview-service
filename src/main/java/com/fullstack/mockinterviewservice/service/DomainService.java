package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.DomainEntity;
import com.fullstack.mockinterviewservice.model.Domain;

public interface DomainService {
    Domain saveDomain(Domain domain);
}
