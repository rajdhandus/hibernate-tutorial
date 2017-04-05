package com.raj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args){
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			int studentId = 1;
			
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, studentId);
			
			theStudent.setFirstName("Raj");
			
			//session.save(theStudent); no need to save explicitly
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student set email='raj123@mail.com'").executeUpdate();
			
			session.getTransaction().commit();
		}
		finally{
			factory.close();
			
		}
	}

}
