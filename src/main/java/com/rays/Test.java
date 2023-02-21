package com.rays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started....");
		
	//	SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		//creating student
		Student st = new Student();
		st.setId(101);
		st.setName("Akshay");
		st.setCity("Inodre");
		
		System.out.println(st);
		
		
		//Creating object of address class
		Address address = new Address();
		address.setStreet("Street1");
		address.setCity("Indore");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(123456789);
		
		//Reading image
		FileInputStream fls = new FileInputStream("src/main/java/com/rays/Index.jpg");
		byte[] data = new byte[fls.available()];
		fls.read(data);
		address.setImage(data);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(address);
		
		tx.commit();
		
		session.close();
		System.out.println("Done...............");
		//System.out.println(factory);
		System.out.println(factory.isClosed());//to check session is closed or not
		
		
		
	}
}
