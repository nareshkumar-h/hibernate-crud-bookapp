package com.naresh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.naresh.model.User;
import com.naresh.util.HibernateUtil;

public class UserDAO {

	public void save(User user) {
		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
		em.close();
		HibernateUtil.close();
	}

	public void update(User user) {

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(user);
		tx.commit();
		em.close();
		HibernateUtil.close();
	}
	
	public void delete(User user) {

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		em.remove(em.contains(user) ? user : em.merge(user));
		tx.commit();
		em.close();
		HibernateUtil.close();
	}
	
	public List<User> findAll() {

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<User> userList = em.createQuery("select u from User u", User.class).getResultList();
		tx.commit();
		em.close();
		HibernateUtil.close();
		
		return userList;
	}
	
	
	public User login(String email, String password) {

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<User> query = em.createQuery("select u from User u where email =:email and password =:password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = query.getSingleResult();
		tx.commit();
		em.close();
		HibernateUtil.close();
		
		return user;
	}
	
	public User findOne(Long id) {

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = em.find(User.class, id);
		tx.commit();
		em.close();
		HibernateUtil.close();
		
		return user;
	}
}
