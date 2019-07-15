package com.cleartrip.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cleartrip.dao.Flights_Dao;
import com.cleartrip.drivers.BrowserDriver;
import com.cleartrip.drivers.ConfigDriver;
import com.cleartrip.pom.Flights_Pom;

public class HotelBookingTest {

	WebDriver wd;
	Flights_Pom flights_Pom;
	Flights_Dao flights_Dao = new Flights_Dao();
	Properties property = new Properties();
	
	
	@BeforeClass
	public void setUp() {
		wd = BrowserDriver.getInstance();
		String URL =  ConfigDriver.getInstance().getProperty("url");		
		wd.get(URL);
		FileInputStream fs;
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\TestData\\FlightBookingTest.properties");
			property.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 @Test
	 public void shouldBeAbleToSearchForHotels() {
	        setDriverPath();

	        driver.get("https://www.cleartrip.com/");
	        hotelLink.click();

	        localityTextBox.sendKeys("Indiranagar, Bangalore");

	        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
	        searchButton.click();

	        driver.quit();

	    }
}
