package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
	//	load the spring configulation file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		
	//	Coach theCoach = context.getBean("myCricketCoach", Coach.class); 
		
		Coach theCoach = context.getBean("testCoach", Coach.class); 
		
		
		//call method on bean
	theCoach.getDailyFortune();
	theCoach.getDailyWorkout();
		
	/*System.out.println(theCoach.getDailyWorkout());
	System.out.println(theCoach.getDailyFortune());
	System.out.println(theCoach.getDailyWorkout());*/
	
		
		//close the context
		context.close();
		
	}

}
