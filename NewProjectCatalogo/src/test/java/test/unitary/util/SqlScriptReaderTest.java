package test.unitary.util;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.ideaiseletronics.catalogo.util.SqlScriptReader;

@RunWith(JUnit4.class)
public class SqlScriptReaderTest {
	
	private Connection connection;
	private SqlScriptReader scriptReader;
	
	@Before
	public void setUp() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/catalogo", "root", "");
		} catch (SQLException e) {
			fail("Nao foi possivel estabelecer uma conexao com o banco");
		}
		scriptReader = new SqlScriptReader(new ScriptRunner(connection));
	}
	
	@Test
	public void run_script_test(){
		File sqlScript = new File("/home/uila/Ideais/EstagioCatalogo/NewProjectCatalogo/src/test/resources/sql-script");
		try {
			
			scriptReader.runScript(sqlScript);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Nao foi possivel rodar o sql script " + sqlScript);
		}
	}
	

}
