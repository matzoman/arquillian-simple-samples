package com.example;

import javax.ejb.Local;

@Local
public interface HelloEJBLocal {

	public String sayHello();
}
