package com.example;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloEJBSampleTest extends Arquillian {

	@Deployment
	public static JavaArchive createArchive() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "HelloSampleEJBTest.jar")
				.addClasses(HelloEJBLocal.class, HelloEBJStateless.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return jar;
	}

	@Inject
	HelloEJBLocal helloEJB;

	@Test
	public void testHelloEJB() {
		Assert.assertEquals("Hi!", helloEJB.sayHello());
	}
}
