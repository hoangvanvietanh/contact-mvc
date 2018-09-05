package com.green.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="email_contact")
public class EmailContact {
	@Id
	@Column(name="id_email_contact")
	private int id_email;
	
	@ManyToOne
	@JoinColumn(name="id_contact")
	private Contact contact;
	
	@Column(name="email_contact")
	private String email_contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getEmail_contact() {
		return email_contact;
	}

	public void setEmail_contact(String email_contact) {
		this.email_contact = email_contact;
	}
	
	
}
