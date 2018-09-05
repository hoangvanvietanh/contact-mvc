package com.green.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import utils.Gender;

@Entity
@Table(name="contact")
public class Contact {
	@Id
	private int id_contact;
	@Column(name="name_contact")
	private String name_contact;
	@Column(name="address_contact")
	private String address_contact;
	@Column(name="avatar_contact")
	private String avatar_contact;
	@Column(name="birthday_contact")
	private String birthday_contact;
	@Enumerated(EnumType.STRING)
	@Column(name="gender_contact")
	private Gender gender_contact;
	@Column(name="note_contact")
	private String note_contact;
	
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
	public void setBirthday_contact(String date) {
		this.birthday_contact = date;
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
