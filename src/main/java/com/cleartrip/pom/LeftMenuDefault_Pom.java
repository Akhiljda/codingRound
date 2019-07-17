package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class LeftMenuDefault_Pom {
		
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;
	
	public LeftMenuDefault_Pom(WebDriver wd) {
		prop1.loadPropertyFile("LeftMenuDefault.properties");	
		this.wd = wd;
						
	}
	public void clickFilghtsMenu() {		
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("Flights_Tab_xpath"))));
	}
	
	public void clickHotelsMenu() {		
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("Hotels_Tab_xpath"))));
	}
}
