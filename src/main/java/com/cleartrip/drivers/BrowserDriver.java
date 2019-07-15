package com.cleartrip.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriver {

	public static WebDriver wd;
	
	public static WebDriver getInstance() {
		
		if (wd == null ) {
			
			String browserName = ConfigDriver.getInstance().getProperty("browser");
			
			 if (browserName.equalsIgnoreCase("Chrome")) {
				 System.out.println("In if "+ browserName);
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\BrowsersDriver\\chromedriver.exe");				 
				 wd = new ChromeDriver();
			 }
			 else if (browserName.equalsIgnoreCase("Firefox")) {
				 wd = new FirefoxDriver();
			 }
			 else if (browserName.equalsIgnoreCase("IE")) {
				 wd = new InternetExplorerDriver();
			 }		
		}
		else System.out.println("No instance of wd");
		return wd;
	}
	
	public BrowserDriver() {
		
	}
	
}
