package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entities.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start the transaction
			session.beginTransaction();
						
			
			//query and display students
			List<Student> students = session.createQuery("from Student").getResultList();
			dispayStudent(students);
			System.out.println("__________________________________________________");
			//get all students with lastname=nitka
			List<Student> targetStudent = session.createQuery("from Student s where s.lastName='Nitka'").getResultList();
			System.out.println("Students with last name=Nitka");
			dispayStudent(targetStudent);
			System.out.println("__________________________________________________");
			//get students last ansme=Kozoan or first name =Lofki
			students = session.createQuery("from Student s where s.lastName='Kozoan' or s.firstName='Lofki'").getResultList();
			dispayStudent(students);
			System.out.println("__________________________________________________");
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!"); 
		}
		finally {
			factory.close();
		}
	}

	private static void dispayStudent(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
