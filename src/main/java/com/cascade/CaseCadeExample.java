package com.cascade;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.one_to_many_map.Answer1;
import com.one_to_many_map.Question1;

public class CaseCadeExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		Question1 question = new Question1();
//		question.setQuestionId(102);
//		question.setQuestion("What is CasCading.....");
//		
//		Answer1 answer1 = new Answer1();
//		answer1.setAnswerId(1004);
//		answer1.setAnswer("In hibernate it is important concept");
//		answer1.setQuestion(question);
//		Answer1 answer2 = new Answer1();
//		answer2.setAnswerId(1005);
//		answer2.setAnswer("In hibernate it is important concept..............");
//		answer2.setQuestion(question);
//		Answer1 answer3 = new Answer1();
//		answer3.setAnswerId(1006);
//		answer3.setAnswer("In hibernate it is important concept**************");
//		answer3.setQuestion(question);
//		
//		List<Answer1> list = new ArrayList<>() ;
//		list.add(answer1);
//		list.add(answer2);
//		list.add(answer3);
//		
//		question.setAnswers(list);
//		
//		
//		session.save(question);
//		session.save(answer1);
//		session.save(answer2);
//		session.save(answer3);
		
		//or
		
		Question1 question = new Question1();
		question.setQuestionId(103);
		question.setQuestion("What is CasCading++++++++++++++++++++");
		Answer1 answer1 = new Answer1();
		answer1.setAnswerId(1007);
		answer1.setAnswer("In hibernate it is important concept+++++++++++++++++++++++++");
		answer1.setQuestion(question);
		
		List<Answer1> list = new ArrayList<>() ;
		list.add(answer1);
		
		question.setAnswers(list);

		session.save(question);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
