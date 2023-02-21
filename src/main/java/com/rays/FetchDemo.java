package com.rays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		//get()        load()
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		/*
		 * 
		 * get()>>>>>>>>studentId:101...........102
		 */
		 Student student = (Student)session.get(Student.class, 101);
		// Student student = (Student)session.get(Student.class, 102);
		// System.out.println(student);
		
		/*
		 * 
		 * load()>>>>>>>>student:101.............102
		 */
		// Student student1 = (Student)session.load(Student.class, 101);
		//Student student1 = (Student)session.load(Student.class, 102);
		//System.out.println(student1);
		session.close();
		factory.close();
	}
}
