package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.ContactEntity;
import com.fullstack.mockinterviewservice.model.Contact;
import com.fullstack.mockinterviewservice.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        ContactEntity newContact = ContactEntity.builder()
                .emailF(contact.getEmailS())
                .nameF(contact.getNameS())
                .iconF(contact.getIconS())
                .emailS(contact.getEmailF())
                .nameS(contact.getNameF())
                .iconS(contact.getIconF())
                .build();
        contactRepository.save(newContact);
        return contact;
    }

    @Override
    public List<Contact> getContacts(String email) {
        List<ContactEntity> contacts = contactRepository.getByEmailF(email);
        return contacts.stream()
                .map(contactEntity -> Contact.builder()
                        .id(contactEntity.getId())
                        .emailF(contactEntity.getEmailF())
                        .nameF(contactEntity.getNameF())
                        .iconF(contactEntity.getIconF())
                        .emailS(contactEntity.getEmailS())
                        .nameS(contactEntity.getNameS())
                        .iconS(contactEntity.getIconS())
                        .build())
                .toList();
    }
}
