package com.luv2code.hibernate.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		// (if you don't specify "hibernate.cfg.xml" then it will default take the same
		// name file & if your configuration file's name is different then you must
		// specify the name )

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			System.out.println("Transavtion begin");
			
			
			//Instructor instructor=session.get(Instructor.class, theId);
			
			//Course course = session.get(Course.class, 1);
			
			//Instructor instructor = session.get(Instructor.class, 1);
			
			
		//	System.out.println(course);
			
			   Query query = session.createQuery("from course c where c.id = 2");
			   
			   List queryResultList=query.getResultList();
			
			   
			   System.out.println(queryResultList);
			
			   /* Gson gson = new Gson();
			 String courseString = gson.toJson(course);
			 System.out.println(courseString);*/
			
			
			// commit the transaction
			session.getTransaction().commit();

		} finally {

		}

	}

}
