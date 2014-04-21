package test.integration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import test.AbstractTest;

@ContextConfiguration("classpath*:spring/integrationTestContext.xml")
public class AbstractIntegrationTest extends AbstractTest {
	
	@Autowired
	private BasicDataSource dataSource;

	@Override
	protected String getFile() {
		return "";
	}

	@Override
	protected BasicDataSource getDataSource() {
		return this.dataSource;
	}

}
