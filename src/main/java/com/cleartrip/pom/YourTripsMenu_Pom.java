package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class YourTripsMenu_Pom {
	
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;
	
	public YourTripsMenu_Pom(WebDriver wd) {
		System.out.println("YourTripsMenu_Pom : Begin!");
		this.wd = wd;
		prop1.loadPropertyFile("YourTripsMenu.properties");
		System.out.println("YourTripsMenu_Pom : End!");
	}
	
	public void clickSignInButton() {
		System.out.println("YourTripsMenu_Pom clickSignInButton: Begin!");
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("SignIn_MenuItem_Btn_xpath"))));
		System.out.println("YourTripsMenu_Pom clickSignInButton: End!");
	}
}
