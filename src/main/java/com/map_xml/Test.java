package com.map_xml;



import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Test {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Person person = new Person(101,"Neeraj","Indore","9111388907");
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
