package rnd.tdm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.SQLiteDBUtil;

public class ConsumeNewUser {

	@DataProvider(name = "consumeNewUser_provider1")
	public Object[][] createUserDataProvider(){
		Connection conn = SQLiteDBUtil.connectDB("resources/TDMDemo01.db");
		ResultSet res = SQLiteDBUtil.getResultSet(conn, "select id from users where status = 'new' AND type = 'user' LIMIT 1;");
		
		Object[][] dataSet = SQLiteDBUtil.convertResultSetToDataProvider(res);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSet;
				
	}
	//
	
@Test(dataProvider = "consumeNewUser_provider1")
  public void f(String id) {
	
	//do whatever you want with that ID, test data
	//when done, update the test data as used in DB
	Connection conn = SQLiteDBUtil.connectDB("resources/TDMDemo01.db");
	String uodateStmt = "UPDATE users set status = 'active' where id = '" + id + "';";
	int rowsUpdated = SQLiteDBUtil.updateData(conn, uodateStmt);
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*
	 * UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
	 */
	
  }
}
