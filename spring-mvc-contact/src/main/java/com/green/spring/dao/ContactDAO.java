package com.green.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.spring.entity.Contact;

@Repository
public class ContactDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Contact> findAll()
	{
		Session session = sessionFactory.openSession();
		TypedQuery<Contact> query = session.createQuery("FROM Contact", Contact.class);
		List<Contact> contact = query.getResultList();
		return contact;
	}
}
