package com.openapi.swagger.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080/v2/api-docs
// http://localhost:8080/swagger-ui.html
// http://localhost:8080/api/
// http://localhost:8080/api/3


@RestController
@RequestMapping("/api")
public class AddressBookResource {
	ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

	@GetMapping("/{id}")
	public Contact getContact(@PathVariable String id) {
		return contacts.get(id);
	}

	@GetMapping("/")
	public List<Contact> getAllContact() {
		return new ArrayList<Contact>(contacts.values());
	}
	
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact) {
		
		contacts.put(contact.getId(), contact);
		return contact;
		
	}

}
