package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDeleteExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Student s where s.city = : c");
		
		query.setParameter("c", "indore");
		
		int result = query.executeUpdate();
		System.out.println("Deleted");
		System.out.println(result);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
