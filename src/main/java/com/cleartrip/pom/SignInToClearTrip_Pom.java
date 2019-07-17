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
		this.wd = wd;
		prop1.loadPropertyFile("SignIn.properties");			
	}
	public void fillSignIndetails(SignInToClearTrip_Dao signInToClearTrip_Dao) {
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("Username_TB_xpath"))), signInToClearTrip_Dao.getUsername());
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("Password_TB_xpath"))), signInToClearTrip_Dao.getPassword());		
	}
	
	public void clickSignInButton() {
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("SignIn_Btn_xpath"))));
	}
	
	public boolean verifyHotelsPageLoaded(WebDriver wd) {
		
		String text =p1.getProperty("Password_TB_xpath");
		
		return web.verifyWebElementLoad(wd, text);
		
	}
}
