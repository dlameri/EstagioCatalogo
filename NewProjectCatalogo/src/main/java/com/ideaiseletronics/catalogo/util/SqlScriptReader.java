package com.ideaiseletronics.catalogo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.apache.ibatis.jdbc.ScriptRunner;

public class SqlScriptReader {
	
	private ScriptRunner scriptRunner;
	
	public SqlScriptReader(ScriptRunner scriptRunner) {
		this.scriptRunner = scriptRunner;
	}
	
	public void runScript(File fileToRun) throws FileNotFoundException{
		Reader readerSql = new BufferedReader(new FileReader(fileToRun));
		scriptRunner.runScript(readerSql);
	}

}
