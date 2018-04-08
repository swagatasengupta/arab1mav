package autop.testdata;

import java.sql.Connection;
import java.sql.ResultSet;

import org.testng.annotations.DataProvider;

import lib.SQLiteDBUtil;

public class AutopDataProviders {
	
	@DataProvider(name = "autop_createaddress_sqliteProvider")
	public Object[][] getDataCreateAddress() {
		Connection conn = SQLiteDBUtil.connectDB("resources/AutopTestData.db");
		
/*		String qCreateAddress = "select "
				+ "first_name, last_name, company, address1, address2,"
				+ " city, state, zip, homePhone, mobile, additional"
				+ " from CreateAddressData where enabled=1";*/
		String qCreateAddress = "select "
				+ "first_name, last_name, company, address1, address2,"
				+ " city, state, zip, homePhone, mobile, additional"
				+ " from CreateAddressData where first_name='Swagat';";
		ResultSet res = SQLiteDBUtil.getResultSet(conn, qCreateAddress);
		return SQLiteDBUtil.convertResultSetToDataProvider(res);
	}

}
