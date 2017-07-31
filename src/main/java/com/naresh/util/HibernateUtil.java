package com.naresh.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEntityManagerFactory() {

		String PERSISTENT_UNIT_NAME = "BOOKAPP_PU";
		emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
		return emf;
	}

	public static void close() {
		if (emf != null) {
			emf.close();
		}
	}
}
