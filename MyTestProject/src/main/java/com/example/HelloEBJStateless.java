package com.example;

import javax.ejb.Stateless;

@Stateless
public class HelloEBJStateless implements HelloEJBLocal {

	public String sayHello() {
		String hello = "Hello there!";
		System.out.println(hello);
		return hello;
	}

}
