package com.green.spring.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.green.spring.entity.Contact;

import utils.Gender;

public class ContactModel {
	private int id_contact;
	private String name_contact;
	private String address_contact;
	private String avatar_contact;
	private String birthday_contact;
	private Gender gender_contact;
	private String note_contact;
	
	public void fromContact(Contact contact)
	{
		this.setId_contact(contact.getId_contact());
		this.setName_contact(contact.getName_contact());
		this.setAddress_contact(contact.getAddress_contact());
		this.setAvatar_contact(contact.getAvatar_contact());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.setBirthday_contact(dateFormat.format(contact.getBirthday_contact()));
		this.setGender_contact(contact.getGender_contact());
		this.setNote_contact(contact.getNote_contact());
	}
	
	public Contact toContact()
	{
		Contact contact = new Contact();
		contact.setId_contact(this.getId_contact());
		contact.setName_contact(this.getName_contact());
		contact.setAddress_contact(this.getAddress_contact());
		contact.setAvatar_contact(this.getAvatar_contact());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			contact.setBirthday_contact(dateFormat.parse(this.getBirthday_contact()));
		} catch (ParseException e) {
			contact.setBirthday_contact(null);
		}
		this.setBirthday_contact(dateFormat.format(contact.getBirthday_contact()));
		contact.setGender_contact(this.getGender_contact());
		contact.setNote_contact(this.getNote_contact());
		return contact;
	}

	public int getId_contact() {
		return id_contact;
	}

	public void setId_contact(int id_contact) {
		this.id_contact = id_contact;
	}

	public String getName_contact() {
		return name_contact;
	}

	public void setName_contact(String name_contact) {
		this.name_contact = name_contact;
	}

	public String getAddress_contact() {
		return address_contact;
	}

	public void setAddress_contact(String address_contact) {
		this.address_contact = address_contact;
	}

	public String getAvatar_contact() {
		return avatar_contact;
	}

	public void setAvatar_contact(String avatar_contact) {
		this.avatar_contact = avatar_contact;
	}

	public String getBirthday_contact() {
		return birthday_contact;
	}

	public void setBirthday_contact(String string) {
		this.birthday_contact = string;
	}

	public Gender getGender_contact() {
		return gender_contact;
	}

	public void setGender_contact(Gender gender_contact) {
		this.gender_contact = gender_contact;
	}

	public String getNote_contact() {
		return note_contact;
	}

	public void setNote_contact(String note_contact) {
		this.note_contact = note_contact;
	}
	
	
}
