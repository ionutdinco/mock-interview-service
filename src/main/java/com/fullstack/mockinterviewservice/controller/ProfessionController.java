package com.fullstack.mockinterviewservice.controller;

import com.fullstack.mockinterviewservice.entity.DomainEntity;
import com.fullstack.mockinterviewservice.entity.ProfessionEntity;
import com.fullstack.mockinterviewservice.error.DomainEmptyException;
import com.fullstack.mockinterviewservice.error.ProfessionAlreadyExistsException;
import com.fullstack.mockinterviewservice.error.ProfessionEmptyException;
import com.fullstack.mockinterviewservice.model.Domain;
import com.fullstack.mockinterviewservice.model.Profession;
import com.fullstack.mockinterviewservice.service.DomainService;
import com.fullstack.mockinterviewservice.service.ProfessionService;
import com.fullstack.mockinterviewservice.service.ProfessionalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@Slf4j
@RequestMapping("/api/v1/profession")
public class ProfessionController {

    @Autowired
    private DomainService domainService;

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private ProfessionalService professionalService;

    @GetMapping
    public List<Profession> getUserProfessions(@RequestParam String email){
        return professionalService.getProfessionsOfUser(email);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public String addProfession (@RequestParam String domain, @RequestParam String profession) throws ProfessionAlreadyExistsException {
        professionService.saveProfession(profession, domain);
        return "saved";
    }

    @GetMapping("/domain")
    @ResponseStatus(HttpStatus.OK)
    public List<Domain> fetchDomains() throws DomainEmptyException {
        return domainService.getDomains();
    }

    @GetMapping("/professions")
    @ResponseStatus(HttpStatus.OK)
    public List<Profession> fetchProfessions(@RequestParam String domain) throws ProfessionEmptyException {
        return professionService.getProfessionsOfDomain(domain);
    }

    @GetMapping("/domain/size")
    @ResponseStatus(HttpStatus.OK)
    public Integer domainsLength(){
        return domainService.getSize();
    }

}
