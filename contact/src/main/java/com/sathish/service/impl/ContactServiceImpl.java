package com.sathish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.entity.Contact;
import com.sathish.exception.ContactNotFoundException;
import com.sathish.repo.ContactRepository;
import com.sathish.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService{

	@Autowired
	private ContactRepository repo;

	public Integer saveContact(Contact c)
	{
		Integer conId = repo.save(c).getConId();
		return conId;

	}
	public void updateContact(Contact c) {
		if ( ( c.getConId() == null ) || ( !repo.existsById(c.getConId())) )
		{
			throw new ContactNotFoundException("STUDENT '"+c.getConId()+"' NOT EXIST");
		}
		else
		{
			repo.save(c);
		}
	}
	public void deleteContact(Integer id)
	{
		repo.delete(getOneContact(id));
	}
	public Contact getOneContact(Integer id)
	{
		return repo.findById(id).orElseThrow(
				() -> new ContactNotFoundException("CONTACT '"+id+"' NOT THERE"));				

	}
	public List<Contact> getAllContacts(){
		List<Contact> list = repo.findAll();
		return list;

	}
}
