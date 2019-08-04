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
		System.out.println("TopMenuDefault_Pom : Begin!");
		prop1.loadPropertyFile("TopMenu.properties");	
		this.wd = wd;
		System.out.println("TopMenuDefault_Pom : End!");
	}
	
	public void clickCurrencyMenu() {
		
	}
	
	public void clickCountryMenu() {
		
	}
	
	public void clickYourTripsMenu() {
		System.out.println("TopMenuDefault_Pom clickYourTripsMenu: Begin!");
		boolean flag = web.verifyWebElementLoad(wd, p1.getProperty("YourTrips_Menu_xpath"));
		
		System.out.println("flag is: "+flag);
		WebElement ed = wd.findElement(By.xpath(p1.getProperty("YourTrips_Menu_xpath")));
		System.out.println("ed is: "+ed.toString());
		web.clickButton(ed);
		System.out.println("TopMenuDefault_Pom clickYourTripsMenu: End!");
	}
}
