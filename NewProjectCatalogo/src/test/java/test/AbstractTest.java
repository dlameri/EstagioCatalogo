package test;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:spring/dataTestsContext.xml")
public abstract class AbstractTest {
	
	@Autowired
	protected BasicDataSource dataSource;
	
	@Before
	public void setUp() throws Exception {
		executeSqlPrepareDatabase();

	}
	
	private void executeSqlPrepareDatabase() throws Exception {
		SqlRunner runner = new SqlRunner(dataSource.getConnection());
		runner.run(getFile());
	}
	
	protected abstract String getFile();

}
