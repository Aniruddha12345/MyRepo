package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	/*public CricketCoach() {
		System.out.println("Inside no arg constructor");
	}*/
	

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	





	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practise fast bowling for 15 min";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "getDailyFortuneFor Cricket Coach";
	//return fortuneService.getDailyFortune();
	}

}
