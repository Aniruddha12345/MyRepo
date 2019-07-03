package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")

@Component
public class TennisCoach implements Coach {
	
	@Autowired   //if we comment it then the code is run because it is new feature of spring 4.3
    //if there is more than 1 constructor then you have to must specify

	private FortuneService fortuneService;
	
	
	TennisCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
		
	}

	@Override
	public String getDailyWorkout() {
		return "practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


	
}
