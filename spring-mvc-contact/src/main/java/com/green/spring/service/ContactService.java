package com.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.spring.dao.ContactDAO;
import com.green.spring.dao.EmailContactDAO;
import com.green.spring.dao.PhoneContactDAO;
import com.green.spring.entity.Contact;
import com.green.spring.entity.EmailContact;
import com.green.spring.entity.PhoneContact;

@Service
public class ContactService {
	
	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private EmailContactDAO emailContactDAO;
	@Autowired
	private PhoneContactDAO phoneContactDAO;
	
	//Find All-----------------------------------
	public List<Contact> findAll()
	{
		return contactDAO.findAll();
	}
	public List<EmailContact> findAllEmail()
	{
		return emailContactDAO.findAll();
	}
	public List<PhoneContact> findAllPhone()
	{
		return phoneContactDAO.findAll();
	}
	//--------------------------------------------
	public Contact findContact(int id) {
		return contactDAO.find(id);
	}
	
	public List<EmailContact> findEmailById(int id)
	{
		return emailContactDAO.findByID(id);
	}
	
	public Contact createContact(Contact contact) {
		Contact result = contactDAO.create(contact);
		return result;
	}
	public Contact updateContact(Contact contact) {
		Contact result = contactDAO.update(contact);
		return result;
	}
	
	public Contact deleteContact(Contact contact) {
		Contact result = contactDAO.delete(contact);
		return result;
		
	}
	
}
