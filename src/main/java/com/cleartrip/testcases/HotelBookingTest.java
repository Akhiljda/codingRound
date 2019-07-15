package com.cleartrip.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cleartrip.dao.Flights_Dao;
import com.cleartrip.dao.Hotels_Dao;
import com.cleartrip.drivers.BrowserDriver;
import com.cleartrip.drivers.ConfigDriver;
import com.cleartrip.pom.Flights_Pom;
import com.cleartrip.pom.Hotels_Pom;
import com.cleartrip.pom.LeftMenuDefault_Pom;
import com.cleartrip.utilities.WebElementsUtility;

public class HotelBookingTest {

	WebDriver wd;
	Hotels_Pom hotels_Pom;
	Hotels_Dao hotels_Dao = new Hotels_Dao();
	Properties property = new Properties();
	WebElementsUtility webElementsUtility;
	LeftMenuDefault_Pom leftMenuDefault_Pom;
	
	@BeforeClass
	public void setUp() {
		wd = BrowserDriver.getInstance();
		hotels_Pom = new Hotels_Pom(wd);
		leftMenuDefault_Pom = new LeftMenuDefault_Pom(wd);
		webElementsUtility = new WebElementsUtility();
		String URL =  ConfigDriver.getInstance().getProperty("url");		
		wd.get(URL);
		FileInputStream fs;
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\TestData\\HotelBookingTest.properties");
			property.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 @Test
	 public void shouldBeAbleToSearchForHotels() {
		 		 
		 hotels_Dao.setWhere(property.getProperty("Where"));
		 hotels_Dao.setCheckin(property.getProperty("checkin"));
		 hotels_Dao.setCheckout(property.getProperty("checkOut"));
		 hotels_Dao.setTravellers(property.getProperty("Travellers"));
		 
		 leftMenuDefault_Pom.clickHotelsMenu();
		 hotels_Pom.fillDetailsSearchForHotelsSection(hotels_Dao);
		 hotels_Pom.clickSearchHotelsButton();	        
	    }
	
	@AfterClass
	public void tearDown() {
		webElementsUtility.closeBrowser(wd);
		webElementsUtility.quitDriver(wd);		
		webElementsUtility= null;
		property = null;
		hotels_Dao = null;
		hotels_Pom = null;
		leftMenuDefault_Pom = null;
		wd = null;		
		}
}
