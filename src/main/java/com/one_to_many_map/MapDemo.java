package com.one_to_many_map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.one_to_many_map.Answer1;
import com.one_to_many_map.Question1;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		/*
		 * Creating Question
		 */
		Question1 question1 = new Question1();
		question1.setQuestionId(101);
		question1.setQuestion("What is java ?");
		
		
		
		
		/*
		 * Creating Answer
		 */
		Answer1 answer1 = new Answer1();
		answer1.setAnswerId(1001);
		answer1.setAnswer("Java is a Programming langauge");
		answer1.setQuestion(question1);
		
		Answer1 answer2 = new Answer1();
		answer2.setAnswerId(1002);
		answer2.setAnswer("With the help of java we can bulid Software");
		answer2.setQuestion(question1);
		
		Answer1 answer3 = new Answer1();
		answer3.setAnswerId(1003);
		answer3.setAnswer("Java has different frameworks");
		answer3.setQuestion(question1);
		
		List<Answer1> list = new ArrayList<Answer1>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);
		
		question1.setAnswers(list);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
		session.save(question1);
		
		
		tx.commit();
		
		
		Question1 question = (Question1)session.load(Question1.class, 101);
		System.out.println(question.getQuestion());
		
		for(Answer1 answer : question.getAnswers()) {
			System.out.println(answer.getAnswer());
		}
		
		
		session.close();
		factory.close();
	}
}


