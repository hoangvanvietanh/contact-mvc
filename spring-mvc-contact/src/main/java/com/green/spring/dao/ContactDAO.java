package com.green.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	public Contact find(int id) {
		return sessionFactory.openSession().find(Contact.class, id);
	}
	
	public Contact create(Contact contact) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(contact);
		tran.commit();
		session.close();
		return contact;
	}
	
	public Contact update(Contact contact) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(contact);
		tran.commit();
		session.close();
		return contact;
	}
	
	public Contact delete(Contact contact) {
		Session session = sessionFactory.openSession();
		Object persistentInstance = session.load(Contact.class, contact.getId_contact());
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		}
		Transaction tran = session.beginTransaction();
		session.save(contact);
		tran.commit();
		session.close();
		return contact;
	}
}
