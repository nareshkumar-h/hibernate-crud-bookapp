package com.naresh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.naresh.model.Book;
import com.naresh.util.HibernateUtil;

public class BookDAO {

	public List<Book> findAll(){
		

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Book> userList = em.createQuery("select b from Book b", Book.class).getResultList();
		tx.commit();
		em.close();
		HibernateUtil.close();
		
		return userList;
	}
	
	public Book findOne(Long id) {

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Book user = em.find(Book.class, id);
		tx.commit();
		em.close();
		HibernateUtil.close();
		
		return user;
	}
}
