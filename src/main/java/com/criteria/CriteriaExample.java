package com.criteria;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.Student;



public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(Student.class);
		
		//criteria.add(Restrictions.eq("city", "Indore"));
		//criteria.add(Restrictions.gt("id", 100));
		criteria.add(Restrictions.ilike("name", "Akshay"));
		
		
		List<Student> list = criteria.list();
		
		for(Student student : list) {
			System.out.println(student);
		}
		session.close();
		factory.close();
	}
}
