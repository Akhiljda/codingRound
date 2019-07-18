package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.dao.Flights_Dao;
import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;


public class Flights_Pom {

	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;
	
	public Flights_Pom(WebDriver wd) {
		prop1.loadPropertyFile("Flights.properties");			
		this.wd = wd;
		
	}
	
	public void fillDetailsSearchFlightsSection(Flights_Dao flights_dao) {		
		String tripType = flights_dao.getTriptype();
		switch(tripType) {
			case "OneWay": {
				web.clickButton(wd.findElement(By.xpath(p1.getProperty("TripType_OneWay_RB_xpath"))));
				break;
			}
			case "RoundTrip": {
				web.clickButton(wd.findElement(By.xpath(p1.getProperty("TripType_RoundTrip_RB_xpath"))));
				break;
			}
			case "MultiTrip": {
				web.clickButton(wd.findElement(By.xpath(p1.getProperty("TripType_MultiCity_RB_xpath"))));
				break;
			}		
		}
		
		System.out.println("From value is: "+flights_dao.getFrom());
		
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("From_DD_xpath"))), flights_dao.getFrom());
		boolean fromRecordDisplayed = web.verifyWebElementLoad(wd, p1.getProperty("From_DD_ResultList_Record1_xpath"));
		
		System.out.println("fromRecordDisplayed? :"+fromRecordDisplayed );
		
		//select from Ajax list
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("To_DD_xpath"))), flights_dao.getTo());		
		boolean toRecordDisplayed = web.verifyWebElementLoad(wd, p1.getProperty("To_DD_ResultList_Record1_xpath"));
		System.out.println("toRecordDisplayed? :"+toRecordDisplayed );
		
		//select from Ajax list
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("DepartOn_CalenderIcon_xpath"))));
		//fill date calender pop up
		web.fillDropDown(wd.findElement(By.xpath(p1.getProperty("Adults_DD_xpath"))), flights_dao.getAdults());
		web.fillDropDown(wd.findElement(By.xpath(p1.getProperty("Children_DD_xpath"))), flights_dao.getChildren());
		web.fillDropDown(wd.findElement(By.xpath(p1.getProperty("Infants_DD_xpath"))), flights_dao.getInfants());
	}
	
	public void clickSearchFlightsButton() {
		
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("SearchFlights_Btn_xpath"))));
	}
	
	public void fillDetailsMoreOptionsSection() {
		
	}
	
	public void clickMoreOptionsLink() {
		
	}
	
	public boolean verifyFlightsPageLoaded(WebDriver wd) {
		
		String text =p1.getProperty("Adults_DD_xpath");
		
		return web.verifyWebElementLoad(wd, text);
				
		
	}
}
