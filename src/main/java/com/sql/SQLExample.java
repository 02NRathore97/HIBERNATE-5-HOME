package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.rays.Student;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory factory  = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//SQL Query
		String query = "Select * from student";
		NativeQuery nq = session.createSQLQuery(query);
		List<Object []> list = nq.list();
		
		for(Object[] student : list) {
			System.out.println(Arrays.deepToString(student));
			System.out.println(student[1] +"......"+ student[2]);
		}
		session.close();
		factory.close();
	}
}
