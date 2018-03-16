package rnd;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.ExcelUtil;
import lib.SQLiteDBUtil;

public class SQLiteDataProviderTestNGDemo1 {

	@DataProvider(name = "sqlite_provider1")
	public Object[][] xlsDataProvider(){

		Connection conn = SQLiteDBUtil.connectDB("resources/TestSQLiteDB01.db");
		ResultSet res = SQLiteDBUtil.getResultSet(conn, "select EMP_ID,EMP_NAME from Table01 where ENABLED = 1;");
		
		Object[][] dataSet = SQLiteDBUtil.convertResultSetToDataProvider(res);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSet;
		
	}
	
	@Test(dataProvider = "sqlite_provider1")
	public void test01(int emp_id, String emp_name) {
		System.out.println("------------------");
		System.out.println("Data Set");
		System.out.println("ID: " + emp_id + ", Name: "+ emp_name);
		System.out.println("------------------");
		
	}
	
}
