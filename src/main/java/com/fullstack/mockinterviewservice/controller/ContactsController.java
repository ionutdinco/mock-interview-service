package com.fullstack.mockinterviewservice.controller;

import com.fullstack.mockinterviewservice.model.Contact;
import com.fullstack.mockinterviewservice.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/contacts")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @PostMapping
    public Contact addContact(@RequestBody Contact contact){
        return contactsService.postContact(contact);
    }

    @GetMapping
    public List<Contact> getContacts(@RequestParam String email){
        return contactsService.getContacts(email);
    }
}
