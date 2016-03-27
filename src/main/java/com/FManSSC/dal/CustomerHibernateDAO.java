package com.FManSSC.dal;

import org.hibernate.Session;

import com.FManSSC.model.customer.Customer;

public class CustomerHibernateDAO {

	public void addCustomer(Customer cust) {
		//TODO: Verify
		System.out.println("*************** Adding customer information in DB with ID ...  " + cust.getId());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(cust);
		session.getTransaction().commit();
	}
	
	public void deleteCustomer(Customer cust) {
		System.out.println("*************** Deleteing customer information in DB with ID ...  " + cust.getId());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(cust);
		session.getTransaction().commit();
	}
	
}
