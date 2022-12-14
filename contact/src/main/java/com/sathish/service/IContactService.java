package com.sathish.service;

import java.util.List;

import com.sathish.entity.Contact;

public interface IContactService {
	Integer saveContact(Contact c);
	void updateContact(Contact s);
	void deleteContact(Integer id);
	Contact getOneContact(Integer id);
	List<Contact> getAllContacts();
}
