package com.raj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try{
			int empId = 1;
			
			session.beginTransaction();
			
			Employee tempEmployee = session.get(Employee.class, empId);
			
			session.delete(tempEmployee);
			
			session.createQuery("delete Employee e where id='2'").executeUpdate();
			
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
		
	}

}
