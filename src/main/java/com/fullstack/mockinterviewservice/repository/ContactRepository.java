package com.fullstack.mockinterviewservice.repository;

import com.fullstack.mockinterviewservice.entity.ContactEntity;
import com.fullstack.mockinterviewservice.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    List<ContactEntity> getByEmailF(String email);
}
