package com.FManSSC.dal;

import java.net.URI;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatePGSQLHelper {
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration config = new Configuration().configure();
			URI database = new URI(System.getenv("DATABASE_URL"));
			String [] user = database.getUserInfo().split(":");
			String builtUrl = "jdbc:postgresql://" + database.getHost() + ":" + database.getPort() + database.getPath();
			
			config.setProperty("hibernate.connection.url", builtUrl);
			config.setProperty("hibernate.connection.username", user[0]);
			config.setProperty("hibernate.connection.password", user[1]);
			
			sessionFactory = config.buildSessionFactory();
			System.out.println("*************** Session Factory instantiated ..................");
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
