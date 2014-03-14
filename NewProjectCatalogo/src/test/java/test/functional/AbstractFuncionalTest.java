package test.functional;

import org.apache.commons.dbcp.BasicDataSource;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import test.AbstractTest;

@ContextConfiguration("classpath*:spring/funcionalTestContext.xml")
public abstract class AbstractFuncionalTest extends AbstractTest{
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired @Qualifier("webDriverFirefox")
	protected WebDriver webDriver;
	@Autowired
	protected String applicationUrlBase;

	@Override
	protected String getFile() {
		return "sql/prepareDatabaseSystemTests.sql";
	}
	
	@Override
	protected void setDataSource() {
		super.dataSource = this.dataSource; 
	}

}
