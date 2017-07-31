package com.naresh.dao;

import java.util.List;

import com.naresh.dao.UserDAO;
import com.naresh.model.User;

public class TestUserDAO {

	static UserDAO userDAO = new UserDAO();

	public static void main(String[] args) {

		testInsert();

		testListAllUsers();

		testUpdate();

		testListAllUsers();

		testDelete();

		testListAllUsers();

	}

	private static void testDelete() {
		User findOne = userDAO.findOne(3L);
		System.out.println("for delete:" + findOne);

		userDAO.delete(findOne);
	}

	private static void testUpdate() {
		User findOne = userDAO.findOne(1L);
		System.out.println("FindOne:" + findOne);

		findOne.setName("Naresh Kumar");

		userDAO.update(findOne);
	}

	private static void testInsert() {
		User u = new User();
		u.setName("Siva1");
		u.setEmail("siva1@gmail.com");
		u.setPassword("pass123");
		//userDAO.save(u);
	}

	private static void testListAllUsers() {
		List<User> userList = userDAO.findAll();
		userList.forEach(System.out::println);
	}

}
