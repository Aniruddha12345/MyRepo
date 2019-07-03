package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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

			// start a transaction
			session.beginTransaction();

			// retrieve student object
			student student1 = session.get(student.class, 1);
			System.out.println(student1);

			// retrieve all students by hql
			List<student> studentList = session.createQuery("from student").getResultList();
			System.out.println(studentList);

			// retrieve students whos lastName = "karuley"
			List<student> studentList1 = session.createQuery("from student s  where s.email = 'Karuley'")
					.getResultList();
			System.out.println(studentList1);

			// LIKE query
			List<student> studentList2 = session.createQuery("from student s  where s.email like '%gmail.com'")
					.getResultList();
			System.out.println(studentList2);

			// commit the transaction
			session.getTransaction().commit();

		} finally {

		}

	}

}
