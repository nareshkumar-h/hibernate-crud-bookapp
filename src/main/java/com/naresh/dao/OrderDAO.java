package com.naresh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.naresh.model.Order;
import com.naresh.model.User;
import com.naresh.util.HibernateUtil;

public class OrderDAO {

	public void save(Order order) {
		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(order);
		tx.commit();
		em.close();
		HibernateUtil.close();
	}

	public List<Order> findAll() {

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Order> userList = em.createQuery("select o from Order o", Order.class).getResultList();
		tx.commit();
		em.close();
		HibernateUtil.close();

		return userList;
	}
	
	
	public List<Order> findMyOrders(Long userId) {

		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Order> query = em.createQuery("select o from Order o where o.user.id = :userId", Order.class);
		query.setParameter("userId", userId);
		List<Order> userList = query.getResultList();
		tx.commit();
		em.close();
		HibernateUtil.close();

		return userList;
	}
}
