package test;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.Before;

public abstract class AbstractTest{
	
	protected BasicDataSource dataSource;
	
	@Before
	public void setUp() throws Exception {
		setDataSource();
		executeSqlPrepareDatabase();

	}
	
	private void executeSqlPrepareDatabase() throws Exception {
		SqlRunner runner = new SqlRunner(dataSource.getConnection());
		if("".equals(getFile())){
			runner.run(getFile());
		}
	}
	
	protected abstract String getFile();
	protected abstract void setDataSource();

}
