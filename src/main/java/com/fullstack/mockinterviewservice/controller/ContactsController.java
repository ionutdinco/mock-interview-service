package com.fullstack.mockinterviewservice.controller;

import com.fullstack.mockinterviewservice.model.Contact;
import com.fullstack.mockinterviewservice.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @PostMapping
    public Contact addContact(@RequestBody Contact contact){

        return contactsService.postContact(contact);
    }
}
