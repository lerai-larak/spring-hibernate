package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entities.Student;

public class DeleteStudentDemo {

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
			
			//delete this student
//			session.delete(student);
			
			//delete student using second method (HQL)
			session.createQuery("delete from Student where id=3").executeUpdate();

			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
