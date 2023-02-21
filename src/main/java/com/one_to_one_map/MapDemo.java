package com.one_to_one_map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		/*
		 * Creating Question
		 */
		Question question1 = new Question();
		question1.setQuestionId(101);
		question1.setQuestion("What is java ?");
		
		Question question2 = new Question();
		question2.setQuestionId(102);
		question2.setQuestion("What is Collection Framework ?");
		
		/*
		 * Creating Answer
		 */
		Answer answer1 = new Answer();
		answer1.setAnswerId(1001);
		answer1.setAnswer("Java is a Programming langauge");
		answer1.setQuestion(question1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(1002);
		answer2.setAnswer("API to work with group of Objects");
		answer2.setQuestion(question2);
		
		question1.setAnswer(answer1);
		question2.setAnswer(answer2);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(answer1);
		session.save(answer2);
		session.save(question1);
		session.save(question2);
		
		
		tx.commit();
		
		
		Question question = (Question)session.load(Question.class, 101);
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswer().getAnswer());
		session.close();
		factory.close();
	}
}
