package com.sathish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
