package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class LeftMenuDefault_Pom {
	
	private WebElement Flights_Tab_xpath;
	private WebElement Hotels_Tab_xpath;

	
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	
	public LeftMenuDefault_Pom(WebDriver wd) {
		prop1.loadPropertyFile("LeftMenuDefault.properties");	
		Flights_Tab_xpath = wd.findElement(By.xpath(p1.getProperty("Flights_Tab_xpath")));
		Hotels_Tab_xpath = wd.findElement(By.xpath(p1.getProperty("Hotels_Tab_xpath")));				
	}
	public void clickFilghtsMenu() {
		web.clickButton(Flights_Tab_xpath);
	}
	
	public void clickHotelsMenu() {
		web.clickButton(Hotels_Tab_xpath);
	}
}
