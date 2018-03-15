package rnd;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnectDemo1 {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		String sqliteConn = "jdbc:sqlite:";		
		String dbPath = "resources/TestSQLiteDB01.db";
		
		sqliteConn += new File(dbPath).getAbsolutePath();
		
		System.out.println("connect string: " + sqliteConn);
		
		try {
			//first get connected to the database
			conn = DriverManager.getConnection(sqliteConn);
			System.out.println("Connection succeeded!");
			//prepare statement 
			if(conn != null) {
				Statement stmt = conn.createStatement();
				
				String strQuery = "select * from Table01";
				
				ResultSet res = stmt.executeQuery(strQuery);
				
				while(res.next()) {
					System.out.println("emp id: " + res.getInt("EMP_ID")
						+ ", emp Name: " + res.getString("EMP_NAME"));
					
				}
				
				conn.close();
				

			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
