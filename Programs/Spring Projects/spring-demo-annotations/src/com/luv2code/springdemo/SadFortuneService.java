package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
	
		return "this is your worst day";
	}

}
