package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.dao.SignInToClearTrip_Dao;
import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class SignInToClearTrip_Pom {
		
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;
	
	public SignInToClearTrip_Pom(WebDriver wd) {
		System.out.println("SignInToClearTrip_Pom: Begin!");
		this.wd = wd;
		prop1.loadPropertyFile("SignIn.properties");
		System.out.println("SignInToClearTrip_Pom: End!");
	}
	public void fillSignIndetails(SignInToClearTrip_Dao signInToClearTrip_Dao) {
		System.out.println("SignInToClearTrip_Pom fillSignIndetails: Begin!");
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("Username_TB_xpath"))), signInToClearTrip_Dao.getUsername());
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("Password_TB_xpath"))), signInToClearTrip_Dao.getPassword());
		System.out.println("SignInToClearTrip_Pom fillSignIndetails: End!");
	}
	
	public void clickSignInButton() {
		System.out.println("SignInToClearTrip_Pom clickSignInButton: Begin!");
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("SignIn_Btn_xpath"))));
		System.out.println("SignInToClearTrip_Pom clickSignInButton: End!");
	}
	
	public boolean verifySignInPageLoaded(WebDriver wd) {
		System.out.println("SignInToClearTrip_Pom verifyHotelsPageLoaded: Begin!");
		String text =p1.getProperty("Password_TB_xpath");		
		return web.verifyWebElementLoad(wd, text);		
	}
	
	public boolean verifyErrorSectionDisplayed(WebDriver wd) {
		System.out.println("SignInToClearTrip_Pom verifyErrorSectionDisplayed: Begin!");
		String text =p1.getProperty("ErrorMsg_Section_xpath");		
		return web.verifyWebElementLoad(wd, text);		
	}
	
}
