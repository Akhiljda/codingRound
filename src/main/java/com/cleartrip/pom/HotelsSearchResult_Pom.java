
package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class HotelsSearchResult_Pom {
		
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;	
	
	public HotelsSearchResult_Pom(WebDriver wd) {
		System.out.println("HotelsSearchResult_Pom: Begin!");
		this.wd = wd;
		prop1.loadPropertyFile("HotelsSearchResult.properties");
		System.out.println("HotelsSearchResult_Pom: End!");
	}
		
	public boolean verifyHotelsSearchResultPageLoaded() {
		System.out.println("HotelsSearchResult_Pom: verifyHotelsSearchResultPageLoaded: BeginOnly!");
		String text =p1.getProperty("HotelsSearchResult_xpath");
		
		return web.verifyWebElementLoad(wd, text);
		
	}
}
