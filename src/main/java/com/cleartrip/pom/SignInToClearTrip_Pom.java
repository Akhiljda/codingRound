package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.dao.SignInToClearTrip_Dao;
import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class SignInToClearTrip_Pom {
	private WebElement Username_TB_xpath;
	private WebElement Password_TB_xpath;
	private WebElement SignIn_Btn_xpath;
	
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	
	public SignInToClearTrip_Pom(WebDriver wd) {
		prop1.loadPropertyFile("SignIn.properties");	
		Username_TB_xpath = wd.findElement(By.xpath(p1.getProperty("Username_TB_xpath")));
		Password_TB_xpath = wd.findElement(By.xpath(p1.getProperty("Password_TB_xpath")));
		SignIn_Btn_xpath = wd.findElement(By.xpath(p1.getProperty("SignIn_Btn_xpath")));
	}
	public void fillSignIndetails(SignInToClearTrip_Dao signInToClearTrip_Dao) {
		web.fillTextBox(Username_TB_xpath, signInToClearTrip_Dao.getUsername());
		web.fillTextBox(Password_TB_xpath, signInToClearTrip_Dao.getPassword());		
	}
	
	public void clickSignInButton() {
		web.clickButton(SignIn_Btn_xpath);
	}
}
