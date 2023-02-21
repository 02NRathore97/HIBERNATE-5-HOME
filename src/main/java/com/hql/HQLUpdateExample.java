package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLUpdateExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update Student set city = : c where name = : n");
		
		query.setParameter("c", "Indore");
		query.setParameter("n", "Ankit");
		
		int result = query.executeUpdate();
		System.out.println("Updated.....");
		System.out.println(result);
		
		tx.commit();
		session.close();
		factory.close();
	}
}

