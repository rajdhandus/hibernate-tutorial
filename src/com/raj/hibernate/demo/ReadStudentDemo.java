package com.raj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String[] args){
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Student theStudent = new Student("Rajkumar","Purushothaman","raj@mail.com");
		
		try{
			
			System.out.println("Beginning Transaction");
			
			session.beginTransaction();
			
			System.out.println("Saving the student");
			
			session.save(theStudent);
			
			System.out.println("Commiting the Transaction");
			
			session.getTransaction().commit();
			
			System.out.println("Saved the object to DB: ID is " + theStudent.getId());
			
			System.out.println("Done!");
			
			System.out.println("Get Session for retrieve!");
			
			session = factory.getCurrentSession();
			
			System.out.println("Beginning Transaction");

			session.beginTransaction();
			
			System.out.println("Retrieving the student");

			Student student = session.get(Student.class, theStudent.getId());
			
			System.out.println(student.toString());
			
			session.getTransaction().commit();
			
			System.out.println("Done!");

		}
		finally{
			factory.close();
		}
		
	}

}
