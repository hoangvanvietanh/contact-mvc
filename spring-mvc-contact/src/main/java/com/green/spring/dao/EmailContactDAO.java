package com.green.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.spring.entity.EmailContact;

@Repository
public class EmailContactDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<EmailContact> findAll() {
		Session session = sessionFactory.openSession();
		TypedQuery<EmailContact> query = session.createQuery("FROM EmailContact", EmailContact.class);
		List<EmailContact> email = query.getResultList();
		return email;
	}
	
	public List<EmailContact> findByID(int id) {
		Session session = sessionFactory.openSession();
		String sql = "select c from email_contact c where c.id_contact = :id";
		Query query = session.createQuery(sql);
		query.setParameter("id", id);
		List<EmailContact> email = query.list();
		return email;
	}
}
