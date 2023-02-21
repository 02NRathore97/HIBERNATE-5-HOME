package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.Student;

public class FirstDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Student student = session.get(Student.class, 101);
		System.out.println(student);
		
		Student student1 = session.get(Student.class, 101);
		System.out.println(student1);
		
		System.out.println(session.contains(student1));
		
		session.close();
		factory.close();
	}
}
