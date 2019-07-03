package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
				.buildSessionFactory();
		// (if you don't specify "hibernate.cfg.xml" then it will default take the same
		// name file & if your configuration file's name is different then you must
		// specify the name )

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create student object
			// student theStudent = new student("Aniruddha","Karuley","ani.kal@gmail.com");
			student theStudent1 = new student("Siddarth", "Shinde", "akbnni.kal@gmail.com");
			student theStudent2 = new student("Shalini", "Jha", "ani.kal@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(theStudent1);

			session.save(theStudent2);

			// commit the transaction
			session.getTransaction().commit();

		} finally {

		}

	}

}
