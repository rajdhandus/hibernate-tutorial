package com.raj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	
	public static void main(String[] args){
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			session.beginTransaction();
			int studentId = 2;
			Student theStudent = session.get(Student.class, studentId);
			session.delete(theStudent);
			session.createQuery("delete from Student where id=3").executeUpdate();
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

}
