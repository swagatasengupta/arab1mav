package rnd;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lib.SQLiteDBUtil;

public class SQLiteConnectDemo2 {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		String dbPath = "resources/TestSQLiteDB01.db";
		
		conn = SQLiteDBUtil.connectDB(dbPath);
		String strQuery = "select * from Table01";
		ResultSet res = SQLiteDBUtil.getResultSet(conn, strQuery);
		
		while(res.next()) {
			System.out.println("emp id: " + res.getInt("EMP_ID")
				+ ", emp Name: " + res.getString("EMP_NAME"));
			
		}
		
		String insertQuery = "insert into Table01 ('EMP_ID', 'EMP_NAME')"
				+ "VALUES (4,'Geetesh'),(5,'Jeetu');";
		System.out.println("Rows affected: " + SQLiteDBUtil.insertData(conn, insertQuery));

		String updateQuery = "update Table01 set EMP_Name='Jatin' where EMP_ID=1;";
		System.out.println("Rows affected: " + SQLiteDBUtil.insertData(conn, updateQuery));
		
		
		String deleteQuery = "DELETE FROM Table01 WHERE EMP_ID=4;";
		System.out.println("Rows affected: " + SQLiteDBUtil.deleteData(conn, deleteQuery));
	}
}
