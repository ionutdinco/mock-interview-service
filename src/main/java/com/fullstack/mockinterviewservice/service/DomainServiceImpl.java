package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.DomainEntity;
import com.fullstack.mockinterviewservice.error.DomainEmptyException;
import com.fullstack.mockinterviewservice.model.Domain;
import com.fullstack.mockinterviewservice.repository.DomainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
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

    @Override
    public List<Domain> getDomains() throws DomainEmptyException {
        List<DomainEntity> optionals = domainRepository.findAll();
        if (optionals.size() < 1)
            throw new DomainEmptyException();
        log.info("domains array:{}", optionals);
        return optionals.stream()
                .map((domainEntity -> Domain.builder()
                        .name(domainEntity.getName())
                        .id(domainEntity.getDomainId())
                        .build())).toList();
    }

    @Override
    public Integer getSize() {
        return domainRepository.findAll().size();
    }
}
