package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.rays.Student;

public class HQLPagination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Query<Student> query = session.createQuery("from Student");
		//implementation pagination using hibernate
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Student> list = query.list();
		for(Student student : list){
			System.out.println(student.getId()+" : "+ student.getName());
		}
		
		session.close();
		factory.close();
	}
}
