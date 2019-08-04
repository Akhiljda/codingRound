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
	WebElementsUtility web;
	Properties property = new Properties();
	TopMenuDefault_Pom topMenuDefault_Pom;
	//BrowserDriver driver = new BrowserDriver();
	@BeforeClass
	public void setUp() {
		System.out.println("TC3_ setUp: Begin!");
		//wd = driver.getInstance();
		wd = BrowserDriver.getInstance();
		String URL =  ConfigDriver.getInstance().getProperty("url");		
		wd.get(URL);
		web = new WebElementsUtility();
		signInToClearTrip_Pom = new SignInToClearTrip_Pom(wd);
		topMenuDefault_Pom = new TopMenuDefault_Pom(wd);	
		yourTripsMenu_Pom = new YourTripsMenu_Pom(wd);
		
		FileInputStream fs;
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\TestData\\SignInTest.properties");
			property.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TC3_ setUp: End!");
	}
		 	
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		System.out.println("TC3_ shouldThrowAnErrorIfSignInDetailsAreMissing: Begin!");
		System.out.println("Window1: "+web.getCurrentWindowhandle(wd));
		
		topMenuDefault_Pom.clickYourTripsMenu();
		System.out.println("Window2: "+web.getCurrentWindowhandle(wd));
		yourTripsMenu_Pom.clickSignInButton();
		
		
		web.waitFor(2000);
		System.out.println("Window3: "+web.getCurrentWindowhandle(wd));
		
		web.getWindowsList(wd);
		web.printWindowHandlesName(wd);
		web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s1.png") ;
		web.runJavaScriptExecutor(wd);
		web.waitFor(2000);
		web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s2.png") ;
				
		//boolean visible = signInToClearTrip_Pom.verifySignInPageLoaded(wd);
		//System.out.println("SignIn Pop up displayed?: "+visible);
		//signInToClearTrip_Pom.clickSignInButton();
        
        //String errors1 = driver.findElement(By.id("errors1")).getText();
        //Assert.assertTrue(errors1.contains("There were errors in your submission"));
        //driver.quit();
	 System.out.println("TC3_ shouldThrowAnErrorIfSignInDetailsAreMissing: End!");
    }
	 
	@AfterClass
	public void tearDown() {
		System.out.println("TC3_ tearDown: Begin!");
		web.closeBrowser(wd);
		web.quitDriver(wd);		
		web= null;
		property = null;
		signInToClearTrip_Pom = null;
		yourTripsMenu_Pom = null;
		topMenuDefault_Pom = null;		
		wd = null;
		System.out.println("TC3_ tearDown: End!");
		}
}

	
	
	
	
