package com.cleartrip.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cleartrip.dao.Flights_Dao;
import com.cleartrip.drivers.BrowserDriver;
import com.cleartrip.drivers.ConfigDriver;
import com.cleartrip.drivers.LoggerDriver;
import com.cleartrip.pom.FlightsSearchResult_Pom;
import com.cleartrip.pom.Flights_Pom;
import com.cleartrip.pom.LeftMenuDefault_Pom;
import com.cleartrip.utilities.WebElementsUtility;

public class FlightBookingTest {

	WebDriver wd;	
	Flights_Pom flights_Pom;
	Flights_Dao flights_Dao = new Flights_Dao();
	Properties property = new Properties();
	LeftMenuDefault_Pom leftMenuDefault_Pom;
	FlightsSearchResult_Pom flightsSearchResult_Pom;
	WebElementsUtility web;
	//BrowserDriver driver = new BrowserDriver();
	//Logger log = LoggerDriver.getInstance();
	Logger logger = LogManager.getLogger(FlightBookingTest.class);
	//static Logger log = Logger.getLogger(FlightBookingTest.class.getName());
	
	@BeforeClass
	public void setUp() {
		System.out.println("TC1_ setUp: Begin!");
		logger.info("TC: Begin - FlightBookingTest :: Setup() ");
		logger.error("Error TC: Begin - FlightBookingTest :: Setup() ");
		logger.warn("Warn TC: Begin - FlightBookingTest :: Setup() ");
		logger.fatal("Fatal TC: Begin - FlightBookingTest :: Setup() ");
		//wd = driver.getInstance();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\BrowsersDriver\\chromedriver.exe");
		wd = BrowserDriver.getInstance();
		String URL =  ConfigDriver.getInstance().getProperty("url");
		wd.get(URL);		
		flights_Pom = new Flights_Pom(wd);
		leftMenuDefault_Pom = new LeftMenuDefault_Pom(wd);
		flightsSearchResult_Pom = new FlightsSearchResult_Pom(wd);
		web = new WebElementsUtility();		
		System.out.println("URL is: "+URL);		
		FileInputStream fs;
		
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\TestData\\FlightBookingTest.properties");
			property.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TC1_ setUp: End!");
		//log.info("TC: End - FlightBookingTest :: Setup() ");
	}
	
	 @Test
	 public void testThatResultsAppearForAOneWayJourney() {
		 System.out.println("TC1_ testThatResultsAppearForAOneWayJourney: Begin!");
		 flights_Dao.setTriptype(property.getProperty("triptype"));
		 flights_Dao.setFrom(property.getProperty("from"));
		 flights_Dao.setTo(property.getProperty("to"));
		 flights_Dao.setDeparton(property.getProperty("departon"));
		 flights_Dao.setAdults(property.getProperty("adults"));
		 flights_Dao.setChildren(property.getProperty("children"));
		 flights_Dao.setInfants(property.getProperty("infants"));
		 
		 leftMenuDefault_Pom.clickFilghtsMenu();
		 flights_Pom.fillDetailsSearchFlightsSection(flights_Dao);
		 flights_Pom.clickSearchFlightsButton();
		 
		 web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s1.png") ;
		 
		 boolean resultDisplayed = flightsSearchResult_Pom.verifyFlightsSearchResultPageLoaded();
		 System.out.println("TC1_ testThatResultsAppearForAOneWayJourney: End!");
		 		 
		 Assert.assertTrue(resultDisplayed);
		 
	    }
	 
	@AfterClass
	public void tearDown() {
		System.out.println("TC1_ tearDown: Begin!");
		 web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s3.png") ;
		web.closeBrowser(wd);
		web.quitDriver(wd);		
		web= null;
		wd = null;
		flights_Pom = null; 
		flights_Dao = null;
		property = null;
		leftMenuDefault_Pom = null;
		System.out.println("TC1_ tearDown: End!");
	}
	

}
