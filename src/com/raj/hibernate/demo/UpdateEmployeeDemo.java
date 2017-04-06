package com.raj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.hibernate.demo.entity.Employee;

public class UpdateEmployeeDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try{
			int idEmployee = 1;
			session.beginTransaction();
			Employee tempEmployee = session.get(Employee.class, idEmployee);
			tempEmployee.setCompany("Lowe's Companies Inc");
			session.createQuery("update Employee set company='Lowe''s Companies Inc'").executeUpdate();
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

}
