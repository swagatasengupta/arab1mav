package lib;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDBUtil {

	public static final String SQLITE_JDBC_CONN = "jdbc:sqlite:";

	public static Connection connectDB(String relPathDB) {
		Connection conn = null;
		String absPathDB = new File(relPathDB).getAbsolutePath();

		try {
			conn = DriverManager.getConnection(SQLITE_JDBC_CONN + absPathDB);
		} catch (SQLException e) {
			System.out.println("Error in connecting to DB " + absPathDB + ". Details: " + e.getMessage());
		}
		return conn;
	}

	public static ResultSet getResultSet(Connection conn, String strQuery) {
		ResultSet res = null;
		try {
			Statement stmt = conn.createStatement();
			res = stmt.executeQuery(strQuery);
			
		} catch (SQLException e) {
			System.out.println("Error in executing query: " + strQuery + " " + e.getMessage());

		}

		return res;
	}

	public static DatabaseMetaData createSQLiteDB(String absDBPath) {
		Connection conn = null;
		DatabaseMetaData meta = null;
		try {
			conn = DriverManager.getConnection(SQLITE_JDBC_CONN + absDBPath);
			meta = conn.getMetaData();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error in connecting to DB " + absDBPath + ". Details: " + e.getMessage());
			return null;
		}
		return meta;
	}

	public static int updateData(Connection conn, String insertQuery) {
		int countRowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			countRowsAffected = stmt.executeUpdate(insertQuery);
			if(countRowsAffected > 0) {
				System.out.println("exeucted successfully: " + insertQuery);
			}
			
		} catch (SQLException e) {
			System.out.println("Error in executing query: " + insertQuery + "::" + e.getMessage());
		}
		return countRowsAffected;
	}

	public static int deleteData(Connection conn, String deleteQuery) {
		return updateData(conn, deleteQuery);
	}

	public static int insertData(Connection conn, String updateQuery) {
		return updateData(conn, updateQuery);
	}

	public static Object[][] convertResultSetToDataProvider(ResultSet rs){
		
		Object[][] dataProviderFormat = null;
		Object[] currRecRow = null;
		
    	List<Object[]> records=new ArrayList<Object[]>();
    	/*The concept is to translate every row of recordset into an Object array.
    	Why object - we dont know which type of data does the column hold - integer/ double/ String etc.
    	Every row Or Object [] will be added to a list.
    	Finally, the entire list which contains all the rows of the resordset
    	will be converted to Object[][] from List<Object[]>;*/
    	try {
    		//get how many columns are there in the row. Set size of array using this.
    		//add each column as an element in Object array
     	    int cols = rs.getMetaData().getColumnCount();
         	while(rs.next()){
         		currRecRow = new Object[cols];
        	    for(int i=0; i<cols; i++){
        	    	currRecRow[i] = rs.getObject(i+1);
        	    }
        	    records.add(currRecRow);
         	}
    		
    	} catch (SQLException e) {
    		System.out.println("Error occured in function "
    				+ "makeResultSetCompatibleToTestNGDataProvider: " + e.getMessage());
    		
    	}
    	dataProviderFormat = records.toArray(new Object[records.size()][]);
		return dataProviderFormat;
	}
	

}
