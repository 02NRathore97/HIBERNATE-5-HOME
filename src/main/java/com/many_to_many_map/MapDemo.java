package com.many_to_many_map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp emp1 = new Emp();
		Emp emp2 = new Emp();
		
		emp1.setEid(101);
		emp1.setName("Ram");
		emp2.setEid(102);
		emp2.setName("Shayam");
		
		Project project1 = new Project();
		Project project2 = new Project();
		Project project3 = new Project();
		Project project4 = new Project();
		
		project1.setPid(1);
		project1.setProjectname("Library Management System");
		project2.setPid(2);
		project2.setProjectname("ChatBot");
		project3.setPid(3);
		project3.setProjectname("Ecom Websit");
		project4.setPid(4);
		project4.setProjectname("School Management");
		
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(emp1);
		list1.add(emp2);
		
		list2.add(project1);
		list2.add(project2);
		list2.add(project3);
		list2.add(project4);
		
		
		emp1.setProjects(list2);
		emp2.setProjects(list2);
		project2.setEmps(list1);
		
		
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(project1);
		session.save(project2);
		session.save(project3);
		session.save(project4);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
