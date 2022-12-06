package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.ContactEntity;
import com.fullstack.mockinterviewservice.model.Contact;
import com.fullstack.mockinterviewservice.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements ContactsService{

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Contact postContact(Contact contact) {
        ContactEntity contactEntity = new ContactEntity();
        BeanUtils.copyProperties(contact, contactEntity);
        contactEntity = contactRepository.save(contactEntity);
        contact.setId(contactEntity.getId());
        return contact;
    }
}
