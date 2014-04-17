package test.functional;

import org.apache.commons.dbcp.BasicDataSource;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import test.AbstractTest;

@ContextConfiguration("classpath*:funcional/spring/funcionalTestContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) // nao sei se esta muito certo nao
@Transactional
public abstract class AbstractFuncionalTest extends AbstractTest {
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired @Qualifier("webDriverFirefox")
	protected WebDriver webDriver;
//	@Autowired
	protected String applicationUrlBase;
	
	public AbstractFuncionalTest() {
		System.out.println("passou aqui segundo");
	}

	@Override
	protected String getFile() {
		return "funcional/sql/prepareDatabaseSystemTests.sql";
	}
	
	@Override
	protected BasicDataSource getDataSource() {
		return this.dataSource; 
	}

}
