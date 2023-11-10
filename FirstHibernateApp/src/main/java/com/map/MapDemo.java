package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Question que1 = new Question();
		que1.setQuestionId(121);
		que1.setQuestion("what is java?");
		
		Answer ans1 = new Answer();
		ans1.setAnswerId(131);
		ans1.setAnswer("Java is programming langauge.");
		que1.setAnswer(ans1);
		ans1.setQuestion(que1);
		
		Question que2 = new Question();
		que2.setQuestionId(122);
		que2.setQuestion("what is collection framework?");
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(132);
		ans2.setAnswer("API to work with objects of java.");
		que2.setAnswer(ans2);
		ans2.setQuestion(que2);
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(que1);
		s.save(que2);
		s.save(ans1);
		s.save(ans2);
		
		tx.commit();
		Question newQ=(Question)s.get(Question.class, 121);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		
	    s.close();
		factory.close();
	}

}
