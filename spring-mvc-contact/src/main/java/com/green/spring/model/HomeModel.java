package com.green.spring.model;

import java.util.ArrayList;
import java.util.List;

import com.green.spring.entity.Contact;

public class HomeModel {
	private List<Contact> contacts = new ArrayList<>();

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	
}
