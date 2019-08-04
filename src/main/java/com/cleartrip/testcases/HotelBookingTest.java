package com.cleartrip.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cleartrip.dao.Flights_Dao;
import com.cleartrip.dao.Hotels_Dao;
import com.cleartrip.drivers.BrowserDriver;
import com.cleartrip.drivers.ConfigDriver;
import com.cleartrip.pom.Flights_Pom;
import com.cleartrip.pom.HotelsSearchResult_Pom;
import com.cleartrip.pom.Hotels_Pom;
import com.cleartrip.pom.LeftMenuDefault_Pom;
import com.cleartrip.utilities.WebElementsUtility;

public class HotelBookingTest {

	WebDriver wd;
	Hotels_Pom hotels_Pom;
	Hotels_Dao hotels_Dao = new Hotels_Dao();
	Properties property = new Properties();
	WebElementsUtility web;
	LeftMenuDefault_Pom leftMenuDefault_Pom;
	HotelsSearchResult_Pom hotelsSearchResult_Pom;
	//BrowserDriver driver = new BrowserDriver();
	@BeforeClass
	public void setUp() {
		System.out.println("TC2_ setUp: Begin!");
		//wd = driver.getInstance();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\BrowsersDriver\\chromedriver.exe");
		wd = BrowserDriver.getInstance();
		String URL =  ConfigDriver.getInstance().getProperty("url");		
		wd.get(URL);
		hotels_Pom = new Hotels_Pom(wd);
		leftMenuDefault_Pom = new LeftMenuDefault_Pom(wd);
		hotelsSearchResult_Pom = new HotelsSearchResult_Pom(wd);
		web = new WebElementsUtility();
		
		FileInputStream fs;
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\TestData\\HotelBookingTest.properties");
			property.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TC2_ setUp: End!");
	}
	
	 @Test
	 public void shouldBeAbleToSearchForHotels() {
		 System.out.println("TC2_ shouldBeAbleToSearchForHotels: Begin!");
		 hotels_Dao.setWhere(property.getProperty("Where"));
		 hotels_Dao.setCheckin(property.getProperty("checkin"));
		 hotels_Dao.setCheckout(property.getProperty("checkOut"));
		 hotels_Dao.setTravellers(property.getProperty("Travellers"));
		 
		 leftMenuDefault_Pom.clickHotelsMenu();
		 		 
		 boolean visible  = hotels_Pom.verifyHotelsPageLoaded(wd);
		 
		 if (visible == true ) {		 
			 hotels_Pom.fillDetailsSearchForHotelsSection(hotels_Dao);
			 hotels_Pom.clickSearchHotelsButton();
			 web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s6.png");
		 }
		 else {
			 System.out.println("In Error clause");
		 }
		 
		 boolean resultDisplayed = hotelsSearchResult_Pom.verifyHotelsSearchResultPageLoaded();		 
		 System.out.println("TC2_ shouldBeAbleToSearchForHotels: End!");
		 
		 Assert.assertTrue(resultDisplayed);		 	
	    }
	
	@AfterClass
	public void tearDown() {
		System.out.println("TC2_ tearDown: Begin!");
		web.closeBrowser(wd);
		web.quitDriver(wd);		
		web= null;
		property = null;
		hotels_Dao = null;
		hotels_Pom = null;
		leftMenuDefault_Pom = null;
		wd = null;		
		System.out.println("TC2_ tearDown: End!");
		}
}
