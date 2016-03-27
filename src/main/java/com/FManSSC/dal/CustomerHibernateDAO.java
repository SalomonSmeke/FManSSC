package com.FManSSC.dal;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.customer.Customer;

public class CustomerHibernateDAO {

	public static void addCustomer(Customer cust) {
		//TODO: Verify
		System.out.println("*************** Adding customer information in DB with ID ...  " + cust.getId());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(cust);
		session.getTransaction().commit();
	}

	public static void deleteCustomer(Customer cust) {
		System.out.println("*************** Deleteing customer information in DB with ID ...  " + cust.getId());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(cust);
		session.getTransaction().commit();
	}

	public static Customer retrieveCustomer(String id) {
		try {
			System.out.println("*************** Searcing for customer information with ID ...  " + id);
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());

			org.hibernate.Query getCustQuery = session.createQuery("From Customer where id=:id");		
			getCustQuery.setString("id", id);

			System.out.println("*************** Retrieve Query is ....>>\n" + getCustQuery.toString()); 

			List<?> customers = getCustQuery.list();
			System.out.println("Getting Customer Details using HQL. \n" + customers);

			session.getTransaction().commit();
			return (Customer)customers.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Address retrieveCustomerAddress(String id) {
		try {
			System.out.println("*************** Searcing for customer address information with ID ...  " + id);
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			Query getAddressQuery = session.createQuery("From custAddress where caddress_id=:id");		
			getAddressQuery.setString("id", id);

			System.out.println("*************** Retrieve Query is ....>>\n" + getAddressQuery.toString()); 

			List<?> addresses = getAddressQuery.list();
			System.out.println("Getting Book Details using HQL. \n" + addresses.get(0));

			System.out.println("*************** Retrieve Query is ....>>\n" + addresses.get(0).toString()); 

			session.getTransaction().commit();
			return (Address)addresses.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
