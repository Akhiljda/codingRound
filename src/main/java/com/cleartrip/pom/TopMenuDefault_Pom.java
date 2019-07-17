package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class TopMenuDefault_Pom {
	
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;
	
	public TopMenuDefault_Pom(WebDriver wd) {
		prop1.loadPropertyFile("SignIn.properties");			
	}
	
	public void clickCurrencyMenu() {
		
	}
	
	public void clickCountryMenu() {
		
	}
	
	public void clickYourTripsMenu() {
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("YourTrips_Menu_xpath"))));
	}
}
