package com.rays;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		StudentCertificate student1 = new StudentCertificate();
		student1.setId(101);
		student1.setName("Yash");
		student1.setCity("Indore");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("java");
		certificate.setDuration("1 year");
		
		student1.setCertificate(certificate);
		
		Session session = factory.openSession();
		Transaction tx  = session.beginTransaction();	
		
		/*
		 * Object save
		 */
		session.save(student1);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
