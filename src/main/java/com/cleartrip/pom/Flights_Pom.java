package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.common.HandleDate;
import com.cleartrip.dao.Flights_Dao;
import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;


public class Flights_Pom {

	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;
	private HandleDate date1 = new HandleDate();
	
	public Flights_Pom(WebDriver wd) {
		System.out.println("Flights_Pom : Begin!");
		prop1.loadPropertyFile("Flights.properties");			
		this.wd = wd;
		System.out.println("Flights_Pom : End!");
		
	}
	
	public void fillDetailsSearchFlightsSection(Flights_Dao flights_dao) {
		System.out.println("Flights_Pom fillDetailsSearchFlightsSection: Begin!");
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
		
		//System.out.println("From value is: "+flights_dao.getFrom());
		
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("From_DD_xpath"))), flights_dao.getFrom());
		boolean fromRecordDisplayed = web.verifyWebElementLoad(wd, p1.getProperty("From_DD_ResultList_Record1_xpath"));
		
		System.out.println("fromRecordDisplayed? :"+fromRecordDisplayed );
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("From_DD_ResultList_Record1_xpath"))));
		
		
		//select from Ajax list
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("To_DD_xpath"))), flights_dao.getTo());		
		boolean toRecordDisplayed = web.verifyWebElementLoad(wd, p1.getProperty("To_DD_ResultList_Record1_xpath"));
		System.out.println("toRecordDisplayed? :"+toRecordDisplayed );
		
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("To_DD_ResultList_Record1_xpath"))));
		
		//select from Ajax list
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("DepartOn_CalenderIcon_xpath"))));
		
		web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s2.png") ;
		
		date1.selectDate(wd, flights_dao.getDeparton());
		
		//fill date calender pop up
		web.fillDropDown(wd.findElement(By.xpath(p1.getProperty("Adults_DD_xpath"))), flights_dao.getAdults());
		web.fillDropDown(wd.findElement(By.xpath(p1.getProperty("Children_DD_xpath"))), flights_dao.getChildren());
		web.fillDropDown(wd.findElement(By.xpath(p1.getProperty("Infants_DD_xpath"))), flights_dao.getInfants());
		System.out.println("Flights_Pom fillDetailsSearchFlightsSection: End!");
	}
	
	public void clickSearchFlightsButton() {
		System.out.println("Flights_Pom clickSearchFlightsButton: Begin!");
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("SearchFlights_Btn_xpath"))));
		System.out.println("Flights_Pom clickSearchFlightsButton: End!");
	}
	
	public void fillDetailsMoreOptionsSection() {
		
	}
	
	public void clickMoreOptionsLink() {
		
	}
	
	public boolean verifyFlightsPageLoaded(WebDriver wd) {
		System.out.println("Flights_Pom verifyFlightsPageLoaded: Begin!");
		
		String text =p1.getProperty("Adults_DD_xpath");
		
		System.out.println("Flights_Pom verifyFlightsPageLoaded: End!");
		return web.verifyWebElementLoad(wd, text);
				
		
	}
}
