package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.DomainEntity;
import com.fullstack.mockinterviewservice.model.Domain;
import com.fullstack.mockinterviewservice.repository.DomainRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomainServiceImpl implements DomainService{

    @Autowired
    private DomainRepository domainRepository;
    @Override
    public Domain saveDomain(Domain domain) {
        Optional<DomainEntity> domainEntity = domainRepository.findByNameIgnoreCase(domain.getName());
        if (domainEntity.isPresent()){
            domain.setId(domainEntity.get().getDomainId());
            return domain;
        }
        DomainEntity domainEntity1 = new DomainEntity();
        BeanUtils.copyProperties(domain, domainEntity1);
        domainEntity1 = domainRepository.save(domainEntity1);
        domain.setId(domainEntity1.getDomainId());

        return domain;
    }
}
