package com.green.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.spring.entity.PhoneContact;


@Repository
public class PhoneContactDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<PhoneContact> findAll() {
		Session session = sessionFactory.openSession();
		TypedQuery<PhoneContact> query = session.createQuery("FROM PhoneContact", PhoneContact.class);
		List<PhoneContact> phone = query.getResultList();
		return phone;
	}
}
