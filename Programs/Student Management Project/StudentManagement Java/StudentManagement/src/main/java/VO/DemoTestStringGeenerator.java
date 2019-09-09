package VO;

import dao.MainDaoImpl;

public class DemoTestStringGeenerator {
	
	
	public String randomAlphaNumeric(int count) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	StringBuilder builder = new StringBuilder();
	while (count-- != 0) {
	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
	builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	}
	return builder.toString();
	}
	
	public static void main(String [] args){
		
String testString=new DemoTestStringGeenerator().randomAlphaNumeric(6);
		System.out.println(testString);
	}


}
