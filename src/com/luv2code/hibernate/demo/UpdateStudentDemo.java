package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entities.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		
		try {
			
		
			int studentId = 1;
			
			//create a session
			Session session = factory.getCurrentSession();
			//start the transaction
			session.beginTransaction();
			
			//retrieve student based on the id
			System.out.println("Getting student with id: " + studentId);
			Student student = session.get(Student.class, studentId);
			
			//update the student object
			student.setFirstName("Alexxis");
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//update email for all students
			Session session2 = factory.getCurrentSession();
			session2.beginTransaction();
			session2.createQuery("update Student set email='jks@gmailer.org'").executeUpdate();
			session2.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
