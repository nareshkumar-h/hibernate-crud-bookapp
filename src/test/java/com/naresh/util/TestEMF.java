package com.naresh.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEMF {


	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BOOKAPP_PU");
		System.out.println(emf);
		
		
		

	}

}
