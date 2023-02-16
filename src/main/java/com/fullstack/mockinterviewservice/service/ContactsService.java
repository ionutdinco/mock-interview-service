package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.model.Contact;

import java.util.List;

public interface ContactsService {
    Contact postContact(Contact contact);

    List<Contact> getContacts(String email);
}
