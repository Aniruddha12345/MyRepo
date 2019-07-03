package com.luv2code.hibernate.demo;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class getInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// (if you don't specify "hibernate.cfg.xml" then it will default take the same
		// name file & if your configuration file's name is different then you must
		// specify the name )

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
						session.beginTransaction();
						
		System.out.println("Transavtion begin");

		
		//get instructor detail object
		int theId = 2;
		InstructorDetail instructorDetail=session.get(InstructorDetail.class, theId);
		
		
		
		
		
		//print associate instructor
		
           System.out.println(instructorDetail.getInstructor());		
		
		
		
			
		
			// commit the transaction
			session.getTransaction().commit();

		} finally {

		}

	}

}
