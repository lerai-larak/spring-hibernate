package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entities.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//use the session to save an object
			System.out.println("creating student object");
			Student student = new Student("Pepe","Deche","descge@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student");
			session.save(student);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!"); 
		}
		finally {
			factory.close();
		}
	}

}
