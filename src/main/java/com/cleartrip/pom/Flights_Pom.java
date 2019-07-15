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

	private WebElement TripType_OneWay_RB_xpath;
	private WebElement TripType_RoundTrip_RB_xpath;
	private WebElement TripType_MultiCity_RB_xpath;
	private WebElement From_DD_xpath;
	private WebElement To_DD_xpath;
	private WebElement DepartOn_Date_xpath;
	private WebElement DepartOn_CalenderIcon_xpath;
	private WebElement Adults_DD_xpath;
	private WebElement Children_DD_xpath;
	private WebElement Infants_DD_xpath;
	private WebElement SearchFlights_Btn_xpath;
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	
	public Flights_Pom(WebDriver wd) {
		prop1.loadPropertyFile("Flights.properties");	
		TripType_OneWay_RB_xpath = wd.findElement(By.xpath(p1.getProperty("TripType_OneWay_RB_xpath")));
		TripType_RoundTrip_RB_xpath = wd.findElement(By.xpath(p1.getProperty("TripType_RoundTrip_RB_xpath")));
		TripType_MultiCity_RB_xpath = wd.findElement(By.xpath(p1.getProperty("TripType_MultiCity_RB_xpath")));
		From_DD_xpath = wd.findElement(By.xpath(p1.getProperty("From_DD_xpath")));
		To_DD_xpath = wd.findElement(By.xpath(p1.getProperty("To_DD_xpath")));
		DepartOn_Date_xpath = wd.findElement(By.xpath(p1.getProperty("DepartOn_Date_xpath")));
		DepartOn_CalenderIcon_xpath = wd.findElement(By.xpath(p1.getProperty("DepartOn_CalenderIcon_xpath")));
		Adults_DD_xpath = wd.findElement(By.xpath(p1.getProperty("Adults_DD_xpath")));
		Children_DD_xpath = wd.findElement(By.xpath(p1.getProperty("Children_DD_xpath")));
		Infants_DD_xpath = wd.findElement(By.xpath(p1.getProperty("Infants_DD_xpath")));
		SearchFlights_Btn_xpath = wd.findElement(By.xpath(p1.getProperty("SearchFlights_Btn_xpath")));
	}
	
	public void fillDetailsSearchFlightsSection(Flights_Dao flights_dao) {
		String tripType = flights_dao.getTriptype();
		switch(tripType) {
			case "OneWay": {
				web.clickButton(TripType_OneWay_RB_xpath);
				break;
			}
			case "RoundTrip": {
				web.clickButton(TripType_RoundTrip_RB_xpath);
				break;
			}
			case "MultiTrip": {
				web.clickButton(TripType_MultiCity_RB_xpath);
				break;
			}		
		}
		web.fillTextBox(From_DD_xpath, flights_dao.getFrom());
		//select from Ajax list
		web.fillTextBox(To_DD_xpath, flights_dao.getTo());
		//select from Ajax list
		web.clickButton(DepartOn_CalenderIcon_xpath);
		//fill date calender pop up
		web.fillDropDown(Adults_DD_xpath, flights_dao.getAdults());
		web.fillDropDown(Children_DD_xpath, flights_dao.getChildren());
		web.fillDropDown(Infants_DD_xpath, flights_dao.getInfants());
	}
	
	public void clickSearchFlightsButton() {
		web.clickButton(SearchFlights_Btn_xpath);
	}
	
	public void fillDetailsMoreOptionsSection() {
		
	}
	
	public void clickMoreOptionsLink() {
		
	}
	
	public boolean verifyFlightsPageLoaded(WebDriver wd) {
		
		String text =p1.getProperty("Adults_DD_xpath");
		
		return web.verifyPageLoad(wd, text);
		
	}
}
