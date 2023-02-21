package com.rays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
	public static void main(String[] args) {
	
	//Hibernate Object States	
		//Transient
		//Persistent
		//Detached
		//Removed
		
		System.out.println("Hello.....");
		
		SessionFactory factory  = new Configuration().configure().buildSessionFactory();
		
		//Creating Student object
		StudentCertificate student = new StudentCertificate();
		student.setId(101);
		student.setName("Ram");
		student.setCity("Indore");
		student.setCertificate(new Certificate("Java","1 Year"));
		//Student : Transient State
		
		Session session  = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		//Student : Persistent State - session,database
		
		student.setName("Shayam");
		//Student : Persistent State - session,database
		
		tx.commit();
		session.close();
		//Student : Detached State
		
		student.setName("sachin");
		System.out.println(student.getName());
		factory.close();
	}
}
