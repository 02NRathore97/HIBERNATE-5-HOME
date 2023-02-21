package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class HQLJoinExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("select q.question, q.questionId, a.answer from Question1 as q INNER JOIN q.answers as a");
		
		List<Object []> list = query.getResultList();
		
		for(Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		tx.commit();
		session.close();
		factory.close();
	}
}

