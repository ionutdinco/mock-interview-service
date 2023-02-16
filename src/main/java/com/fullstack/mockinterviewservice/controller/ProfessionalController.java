package com.fullstack.mockinterviewservice.controller;

import com.fullstack.mockinterviewservice.error.ProfessionEmptyException;
import com.fullstack.mockinterviewservice.model.Profession;
import com.fullstack.mockinterviewservice.model.Professional;
import com.fullstack.mockinterviewservice.repository.ProfessionalRepository;
import com.fullstack.mockinterviewservice.service.ProfessionalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/v1/professional")
@Slf4j
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Profession addProfessional(@RequestBody Professional professional) throws ProfessionEmptyException {
        log.info("professional-request:{}", professional);
       return professionalService.addProfessional(professional);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professional> getProfs(@RequestParam String domain){
     return professionalService.getProfessionals(domain);
    }

}
