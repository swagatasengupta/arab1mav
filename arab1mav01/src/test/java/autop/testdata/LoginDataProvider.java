package autop.testdata;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	@DataProvider(name = "autop_lgn01_positive")
	public Object[][] getDataLGN01() {
		
		Object[][] testData = {
				{"swagatasengupta@yahoo.com","MTIzNDU="}
				//{""}
				
			};
		
		return testData;
	}

	@DataProvider(name = "autop_lgn02_positive")
	public Object[][] getDataLGN02() {
		
		Object[][] testData = {
				{"swagatasengupta@yahoo.com","MTIzNDU="},
				{"swati.kota84@gmail.com","b25lc3Rhcg=="}
			};
		
		return testData;
	}
}
