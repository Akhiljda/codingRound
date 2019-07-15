package com.cleartrip.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cleartrip.dao.Hotels_Dao;
import com.cleartrip.drivers.BrowserDriver;
import com.cleartrip.drivers.ConfigDriver;
import com.cleartrip.pom.Hotels_Pom;
import com.cleartrip.pom.LeftMenuDefault_Pom;
import com.cleartrip.pom.SignInToClearTrip_Pom;
import com.cleartrip.pom.TopMenuDefault_Pom;
import com.cleartrip.pom.YourTripsMenu_Pom;
import com.cleartrip.utilities.WebElementsUtility;

public class SignInTest {

	WebDriver wd;
	SignInToClearTrip_Pom signInToClearTrip_Pom;
	YourTripsMenu_Pom yourTripsMenu_Pom;
	WebElementsUtility webElementsUtility;
	Properties property = new Properties();
	TopMenuDefault_Pom topMenuDefault_Pom;
	
	@BeforeClass
	public void setUp() {
		wd = BrowserDriver.getInstance();
		webElementsUtility = new WebElementsUtility();
		signInToClearTrip_Pom = new SignInToClearTrip_Pom(wd);
		topMenuDefault_Pom = new TopMenuDefault_Pom(wd);	
		yourTripsMenu_Pom = new YourTripsMenu_Pom(wd);
		String URL =  ConfigDriver.getInstance().getProperty("url");		
		wd.get(URL);
		FileInputStream fs;
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\TestData\\SignInTest.properties");
			property.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		 	
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

	 topMenuDefault_Pom.clickYourTripsMenu();
	 yourTripsMenu_Pom.clickSignInButton();
	 signInToClearTrip_Pom.clickSignInButton();
        
        //String errors1 = driver.findElement(By.id("errors1")).getText();
        //Assert.assertTrue(errors1.contains("There were errors in your submission"));
        //driver.quit();
    }
	 
	@AfterClass
	public void tearDown() {
		webElementsUtility.closeBrowser(wd);
		webElementsUtility.quitDriver(wd);		
		webElementsUtility= null;
		property = null;
		signInToClearTrip_Pom = null;
		yourTripsMenu_Pom = null;
		topMenuDefault_Pom = null;		
		wd = null;		
		}
}

	
	
	
	
