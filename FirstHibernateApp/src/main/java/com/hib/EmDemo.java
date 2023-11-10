package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		
		
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	      
	        Student student1 = new Student();
	        student1.setId(111);
	        student1.setName("Shubham");
	        student1.setLocation("Newasa");
            
	        Certificate certificate= new Certificate();
	        certificate.setCourse("java");
	        certificate.setDuration("3 month");
	        student1.setCerti(certificate);
	        
	        

	        Student student2 = new Student();
	        student2.setId(112);
	        student2.setName("Siddhesh");
	        student2.setLocation("Nashik");
            
	        Certificate certificate1= new Certificate();
	        certificate1.setCourse("python");
	        certificate1.setDuration("2 month");
	        student2.setCerti(certificate1);
	        
	        
	        Session s = factory.openSession();
	        Transaction tx = s.beginTransaction();
	        s.save(student1);
	        s.save(student2);
	        tx.commit();
	        s.close();
	       factory.close();
	       
	}

}
