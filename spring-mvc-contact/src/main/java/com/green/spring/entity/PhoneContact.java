package com.green.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phone_contact")
public class PhoneContact {
	@Id
	@Column(name="id_phone_contact")
	private int id_phone;
	
	@ManyToOne
	@JoinColumn(name="id_contact")
	private Contact contact;
	
	@Column(name="phone_contact")
	private String phone_contact;

	public int getId_phone() {
		return id_phone;
	}

	public void setId_phone(int id_phone) {
		this.id_phone = id_phone;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getPhone_contact() {
		return phone_contact;
	}

	public void setPhone_contact(String phone_contact) {
		this.phone_contact = phone_contact;
	} 
	
	
}
