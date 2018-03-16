package rnd.tdm;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.SQLiteDBUtil;

public class CreateUser {
	
	@DataProvider(name = "createuser_provider1")
	public Object[][] createUserDataProvider(){
		
		Object[][] data = {
			{"test1@domain.com", "Test 1", "admin"},
			{"test2@domain.com", "Test 2", "user"},
			{"test3@domain.com", "Test 3", "manager"},
			{"test4@domain.com", "Test 4", "admin"},
			{"test5@domain.com", "Test 5", "user"},
			{"test6@domain.com", "Test 6", "manager"},
			{"test7@domain.com", "Test 7", "admin"},
			{"test8@domain.com", "Test 8", "user"},
			{"test9@domain.com", "Test 9", "manager"},
			{"test10@domain.com", "Test 10", "user"}			
		};
		return data;
	}

	
	public static boolean creatUser(String id, String name, String type, String testCaseCreated, String testCaseUpdated) {
		Connection conn = SQLiteDBUtil.connectDB("resources/TDMDemo01.db");
		
		String insertStmt = "insert into users values ('"
				+ id + "','"
				+ name + "','"
				+ type + "', 'new','"
				+ testCaseCreated + "','"
				+ testCaseUpdated + "');";
		
		//INSERT INTO table_name VALUES (value1, value2, value3, ...);
		
		int rowsInsterted = SQLiteDBUtil.insertData(conn, insertStmt);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsInsterted > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Test(dataProvider = "createuser_provider1")
	public void createUser(String id, String name, String type) {
		creatUser(id, name, type, "CreateUser","CreateUser");		
	}
	
	
	
}
