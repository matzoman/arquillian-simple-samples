package com.example;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class HelloEJBUser {

	@Inject
	HelloEJBLocal helloObj;
	
	public String useIt() {
		return helloObj.sayHello();
	}
}
