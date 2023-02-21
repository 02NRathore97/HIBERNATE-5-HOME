package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.rays.Student;

public class HQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//Create HQL Query
		//String query = "from Student";
		//String query = "from Student where city = 'Indore'";
		//String query = "from Student where city = :x";
		String query = "from Student as s where s.city = :x and s.name = :n";
		
		Query query1 = session.createQuery(query);
		
		//query1.setParameter("x", "Indore");
		
		query1.setParameter("x", "Indore");
		query1.setParameter("n", "Abhay");
		//single - unique
		//multiple - list
		
		List<Student> list = query1.list();
		
		for(Student student : list) {
			System.out.println(student.getName() +" : "+ student.getCity());
		}
		session.close();
		factory.close();
	}
}
