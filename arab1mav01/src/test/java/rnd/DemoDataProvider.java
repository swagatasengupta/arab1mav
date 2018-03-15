package rnd;

import org.testng.annotations.DataProvider;

public class DemoDataProvider {
	@DataProvider(name = "test_provider")
	public Object[][] getData() {
		
		 return new Object[][] {
			 {"Swagata", "Sengupta", "swagata.sengupta@devop-trics.com", "CTO"},
			 {"Madhu", "Murty", "madhu@cloudscaleqa.com", "CEO"}
		 	};
	}

}
