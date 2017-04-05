package com.raj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
				
			session.save(new Student("R","P","rp@mail.com"));
			session.save(new Student("A","B","ab@mail.com"));
			session.save(new Student("C","D","cd@mail.com"));
			session.save(new Student("E","F","ef@mail.com"));
			
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}
}
