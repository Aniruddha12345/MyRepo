package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	
	
	

	public static void main(String[] args) {
		//read spring config file
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
         
         //when specify bean id
		//Coach coach = context.getBean("thatSillyCoach", Coach.class);
         
        // when not specifying bean id
         Coach coach = context.getBean("tennisCoach", Coach.class);
         
		
		
		//call a method
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		//close the container
    context.close();

	}

}
