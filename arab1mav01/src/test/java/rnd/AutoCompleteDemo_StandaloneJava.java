package rnd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoCompleteDemo_StandaloneJava {

	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.southwest.com/");
		
		WebElement depart =	driver.findElement(By.id("air-city-departure"));
		depart.clear();
		depart.click();
		depart.sendKeys("New York");
		
		Thread.sleep(2000);
		
		WebElement autoOptions = driver.findElement(By.id("air-city-departure-menu"));
		
		List<WebElement> options = autoOptions.findElements(By.tagName("li"));
		Thread.sleep(2000);
		System.out.println(options.size());
		
		for (WebElement opt : options) {
			//System.out.println(opt.getText());
			if(opt.getText().contains("Buffalo/Niagara")) {
				opt.click();
			}
			//System.out.println(opt.getText());
		}
		
		
		
	}

}
