package com.raj.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			
			List<Student> student = session.createQuery("from Student").getResultList();
			
			displayStudents(student);
			
			student = session.createQuery("from Student s where s.lastName='P'").getResultList();
			
			displayStudents(student);

			student = session.createQuery("from Student s where s.lastName='P' or s.firstName='A'").getResultList();
			
			displayStudents(student);
			
			student = session.createQuery("from Student s where s.email LIKE '%mail.com'").getResultList();
			
			displayStudents(student);
			
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> student) {
		for(Student tmpStudent:student){
			System.out.println(tmpStudent.toString());
		}
	}

}
