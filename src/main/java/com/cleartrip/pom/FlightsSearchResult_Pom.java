package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class FlightsSearchResult_Pom {
		
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;	
	
	public FlightsSearchResult_Pom(WebDriver wd) {
		System.out.println("FlightsSearchResult_Pom: Begin!");
		this.wd = wd;
		prop1.loadPropertyFile("FlightSearchResult.properties");
		System.out.println("FlightsSearchResult_Pom: End!");
	}
	
	public boolean verifyFlightsSearchResultPageLoaded() {
		System.out.println("FlightsSearchResult_Pom: verifyFlightsSearchResultPageLoaded: BeginOnly!");
		String text =p1.getProperty("FlightsSearchResult_xpath");		
		return web.verifyWebElementLoad(wd, text);		
	}
}
