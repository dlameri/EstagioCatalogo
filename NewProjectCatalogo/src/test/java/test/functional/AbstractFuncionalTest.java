package test.functional;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import test.AbstractTest;

@ContextConfiguration({"classpath:spring/application-context.xml", "classpath:spring/dataTestsContext.xml"})
public abstract class AbstractFuncionalTest extends AbstractTest{
	
	@Autowired
	@Qualifier("webDriverChrome")
	protected WebDriver webDriver;
	@Autowired
	protected String urlBase;

	@Override
	protected String getFile() {
		return "sql/prepareDatabaseSystemTests.sql";
	}

}
