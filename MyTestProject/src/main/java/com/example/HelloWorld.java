package com.example;

public class HelloWorld {

	private String beanOutput;
	 
	public void setSpringBeans(String input){
	       beanOutput  = input;
	    }
	 
	public String getBeanValue(){
	   return "Output from Spring Bean : " + beanOutput;
	}

}
