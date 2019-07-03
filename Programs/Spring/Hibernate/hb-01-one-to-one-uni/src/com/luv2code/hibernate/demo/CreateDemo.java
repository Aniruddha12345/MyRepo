package com.luv2code.hibernate.demo;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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

			//create the objects
			
			Instructor tempinstructor = new Instructor("Aniruddha", "Karuley", "anirws@hkas.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("aaaassssjjj","music");
			
			//create assocoation so
			
			tempinstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
						session.beginTransaction();
						
		System.out.println("Transavtion begin");

			
			//save the object
			//note -> this will save the related data into another table because of CascadeType.ALL
			session.save(tempinstructor);
			
			
			
			
			
			
			
			
			
			
			
			
			// commit the transaction
			session.getTransaction().commit();

		} finally {

		}

	}

}
