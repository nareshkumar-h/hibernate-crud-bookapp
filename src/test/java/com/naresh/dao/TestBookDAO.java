package com.naresh.dao;

import java.util.List;

import com.naresh.model.Book;

public class TestBookDAO {

	static BookDAO bookDAO = new BookDAO();
	
	public static void main(String[] args) {	
		
		testListBooks();
	}

	private static void testListBooks() {
		List<Book> bookList = bookDAO.findAll();
		bookList.forEach(System.out::println);
	}
}
