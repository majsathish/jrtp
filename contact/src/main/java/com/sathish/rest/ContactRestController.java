package com.sathish.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.entity.Contact;
import com.sathish.exception.ContactNotFoundException;
import com.sathish.service.IContactService;

@RestController
@CrossOrigin({
	"http://localhost:9690/",
	"http://localhost:4200/"	
})

@RequestMapping("/v1/api/contact")
public class ContactRestController {
	
	@Autowired
	private IContactService service;
	
	@PostMapping("/save")
	
	public ResponseEntity<String> createContact(@RequestBody Contact contact)
	{
		Integer id = service.saveContact(contact);
		String message = "CONTACT '"+id+"' CREATED";
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
		
	}

	@GetMapping("/all")
	public ResponseEntity<List<Contact>> getAllContact()
	{
		List<Contact> list =  service.getAllContacts();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact)
	{
		ResponseEntity<String> response = null;
		try
		{
		service.updateContact(contact);
		response = ResponseEntity.ok("CONTACT '"+contact.getConId() +"' UPDATED");
		}
		catch ( ContactNotFoundException e)
		{
			e.printStackTrace();
			throw e;
		}
		return response;		
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id") Integer id )
	{
		ResponseEntity<String> response = null;
		try {
		service.deleteContact(id);
		response = ResponseEntity.ok("CONTACT '"+ id +"' DELETED");
		}
		catch ( ContactNotFoundException e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		
		return response;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Contact> getOneContact(@PathVariable("id") Integer id )
	{
		ResponseEntity<Contact> response = null;
		try {
		Contact c = service.getOneContact(id);
		response = ResponseEntity.ok(c);
		}
		catch ( ContactNotFoundException e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		
		return response;
	}
	

//	Student getOneStudent(Integer id);
 
}
