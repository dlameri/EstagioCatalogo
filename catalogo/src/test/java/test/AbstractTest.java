package test;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

public abstract class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	protected BasicDataSource dataSource;
	
	public AbstractTest() {
		System.out.println("passou aqui primeiro");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("passou pelo before");
		BasicDataSource dataSource = getDataSource();
		setDataSource(dataSource);
		executeSqlScript(getFile(), false);
	}
	
	private void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	protected abstract String getFile();
	protected abstract BasicDataSource getDataSource();

}
