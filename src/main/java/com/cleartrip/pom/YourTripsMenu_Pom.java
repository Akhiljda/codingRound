package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class YourTripsMenu_Pom {
	
	private WebElement SignIn_MenuItem_Btn_xpath;
	
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	
	public YourTripsMenu_Pom(WebDriver wd) {
		prop1.loadPropertyFile("SignIn.properties");	
		SignIn_MenuItem_Btn_xpath = wd.findElement(By.xpath(p1.getProperty("SignIn_MenuItem_Btn_xpath")));
	}
	
	public void clickSignInButton() {
		web.clickButton(SignIn_MenuItem_Btn_xpath);
	}
}
