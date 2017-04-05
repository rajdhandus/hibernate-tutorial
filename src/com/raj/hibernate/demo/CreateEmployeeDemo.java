package com.raj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {
	public static void main(String[] args){
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			
			Employee emp1 = new Employee("Rajkumar","Purushothaman","rp@company.com");
			Employee emp2 = new Employee("Anuja","Brabaharan","ab@company.com");
			Employee emp3 = new Employee("Anuja","Rajkumar","araj@company.com");
			Employee emp4 = new Employee("Anu","Raj","araj@company.com");

			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}
}
