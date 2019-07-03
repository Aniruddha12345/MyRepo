package com.luv2code.hibernate.demo;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// (if you don't specify "hibernate.cfg.xml" then it will default take the same
		// name file & if your configuration file's name is different then you must
		// specify the name )

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			System.out.println("Transavtion begin");
			
			int theId = 1;
			//Instructor instructor=session.get(Instructor.class, theId);
			
			Course course = session.get(Course.class, 1);
			
		//	System.out.println(course);
			
			/* Gson gson = new Gson();
			 String courseString = gson.toJson(course);
			 System.out.println(courseString);*/
			
			ObjectMapper mapper = new ObjectMapper();
			
			// commit the transaction
			session.getTransaction().commit();

		} finally {

		}

	}

}
