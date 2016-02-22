package com.example;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloWorldServletTest {
	
	@Deployment(testable = false)
	public static EnterpriseArchive createDeployment() {
		EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "test.ear")
				.addAsModule(ShrinkWrap.create(WebArchive.class, "test.war")
						.addClasses(HelloWorldServlet.class, HelloWorld.class).addAsResource("SpringBean.xml"));
		ear.addAsLibraries(Maven.resolver().resolve("org.springframework:spring-context:4.2.4.RELEASE")
				.withTransitivity().asFile());
		return ear;
	}

	@Test
	public void shouldBeAbleToInvokeServletInDeployedWebApp(@ArquillianResource URL url) throws Exception {
		String body = readAllAndClose(new URL(url, "HelloWorldServlet").openStream());
		Assert.assertEquals("Verify that the servlet was deployed and returns expected result",
				"Output from Spring Bean : Hello World!", body);
	}

	private String readAllAndClose(InputStream is) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			int read;
			while ((read = is.read()) != -1) {
				out.write(read);
			}
		} finally {
			try {
				is.close();
			} catch (Exception e) {
			}
		}
		return out.toString();
	}
}