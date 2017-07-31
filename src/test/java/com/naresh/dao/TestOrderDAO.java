package com.naresh.dao;

import java.util.List;

import com.naresh.model.Book;
import com.naresh.model.Order;
import com.naresh.model.User;

public class TestOrderDAO {

	static OrderDAO orderDAO = new OrderDAO();
	static UserDAO userDAO = new UserDAO();
	static BookDAO bookDAO = new BookDAO();

	public static void main(String[] args) {

		testAddOrder();

		testListOrders();

		testListMyOrders();
	}

	private static void testAddOrder() {

		System.out.println("Add an Order");
		Order order = new Order();

		// set user
		User user = userDAO.findOne(1L);
		order.setUser(user);

		// set book
		Book book = bookDAO.findOne(1L);
		order.setBook(book);

		orderDAO.save(order);
	}

	private static void testListOrders() {
		System.out.println("List All Orders");
		List<Order> orderList = orderDAO.findAll();
		orderList.forEach(System.out::println);
	}

	private static void testListMyOrders() {
		System.out.println("List My Orders");
		List<Order> orderList = orderDAO.findMyOrders(1L);
		orderList.forEach(System.out::println);
	}

}
