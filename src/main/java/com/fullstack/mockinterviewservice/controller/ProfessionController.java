package com.fullstack.mockinterviewservice.controller;

import com.fullstack.mockinterviewservice.entity.DomainEntity;
import com.fullstack.mockinterviewservice.entity.ProfessionEntity;
import com.fullstack.mockinterviewservice.error.ProfessionAlreadyExistsException;
import com.fullstack.mockinterviewservice.model.Domain;
import com.fullstack.mockinterviewservice.service.DomainService;
import com.fullstack.mockinterviewservice.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/v1/profession")
public class ProfessionController {

    @Autowired
    private DomainService domainService;

    @Autowired
    private ProfessionService professionService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public String addProfession (@RequestParam String domain, @RequestParam String profession) throws ProfessionAlreadyExistsException {
        professionService.saveProfession(profession, domain);
        return "saved";
    }


}
