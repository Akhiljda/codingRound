package com.cleartrip.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriver {

//private static  WebDriver wd = new ChromeDriver(); 
	/*
	public static WebDriver getInstance() {				
		System.out.println("I reached in wd");
		System.out.println("Thread is: "+Thread.currentThread().getName());
		return wd;
	}
	
	private BrowserDriver() {
		
	}
	*/
	
	
	private static  WebDriver wd;
	
	public static WebDriver getInstance() {
		
		if (wd == null ) {
			System.out.println("I reached in wd");
			System.out.println("Thread is: "+Thread.currentThread().getName());
			String browserName = ConfigDriver.getInstance().getProperty("browser");
			
			 if (browserName.equalsIgnoreCase("Chrome")) {
				 System.out.println("In if "+ browserName);
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\BrowsersDriver\\chromedriver.exe");
				 ChromeOptions options = new ChromeOptions();
				//		 options.addArguments("--user-data-dir=C:/Users/akhil.jain/AppData/Local/Google/Chrome/User Data");						 				 				 
				 wd = new ChromeDriver(options);
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
	
	private BrowserDriver() {
		
	}
	
	/*
public  WebDriver wd;
	
	public  WebDriver getInstance() {
		
		//if (wd == null ) {
			
			String browserName = ConfigDriver.getInstance().getProperty("browser");
			
			 if (browserName.equalsIgnoreCase("Chrome")) {
				 System.out.println("In if "+ browserName);
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\BrowsersDriver\\chromedriver.exe");
				 ChromeOptions options = new ChromeOptions();
				//		 options.addArguments("--user-data-dir=C:/Users/akhil.jain/AppData/Local/Google/Chrome/User Data");						 				 				 
				 wd = new ChromeDriver(options);
			 }
			 else if (browserName.equalsIgnoreCase("Firefox")) {
				 wd = new FirefoxDriver();
			 }
			 else if (browserName.equalsIgnoreCase("IE")) {
				 wd = new InternetExplorerDriver();
			 }		
		//}
		//else System.out.println("No instance of wd");
		return wd;
	}
	
	public BrowserDriver() {
		
	}
	*/
}
