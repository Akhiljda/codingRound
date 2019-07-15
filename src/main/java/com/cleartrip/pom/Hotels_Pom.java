package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.dao.Hotels_Dao;
import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class Hotels_Pom {
	
	private WebElement Where_TB_xpath;
	private WebElement CheckIn_Date_xpath;
	private WebElement CheckOut_Date_xpath;
	private WebElement Travellers_DD_xpath;
	private WebElement SearchHotels_Btn_xpath;
	private WebElement CheckIn_CalenderIcon_xpath;
	private WebElement CheckOut_CalenderIcon_xpath;
	
	
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	
	public Hotels_Pom(WebDriver wd) {
		prop1.loadPropertyFile("Hotels.properties");	
		Where_TB_xpath = wd.findElement(By.xpath(p1.getProperty("Where_TB_xpath")));
		CheckIn_Date_xpath = wd.findElement(By.xpath(p1.getProperty("CheckIn_Date_xpath")));
		CheckIn_CalenderIcon_xpath = wd.findElement(By.xpath(p1.getProperty("CheckIn_CalenderIcon_xpath")));
		CheckOut_Date_xpath = wd.findElement(By.xpath(p1.getProperty("CheckOut_Date_xpath")));
		CheckOut_CalenderIcon_xpath = wd.findElement(By.xpath(p1.getProperty("CheckOut_CalenderIcon_xpath")));
		Travellers_DD_xpath = wd.findElement(By.xpath(p1.getProperty("Travellers_DD_xpath")));
		SearchHotels_Btn_xpath = wd.findElement(By.xpath(p1.getProperty("SearchHotels_Btn_xpath")));		
	}
	
	public void fillDetailsSearchForHotelsSection(Hotels_Dao hotels_dao) {
		
		web.fillTextBox(Where_TB_xpath, hotels_dao.getWhere());
		//select from Ajax list
			
		web.clickButton(CheckIn_CalenderIcon_xpath);
		//fill date calender pop up
		
		web.clickButton(CheckOut_CalenderIcon_xpath);
		//fill date calender pop up
		web.fillDropDown(Travellers_DD_xpath, hotels_dao.getTravellers());
		
	}
	
	public void clickSearchHotelsButton() {
		web.clickButton(SearchHotels_Btn_xpath);
	}
	
	public boolean verifyHotelsPageLoaded(WebDriver wd) {
		
		String text =p1.getProperty("Travellers_DD_xpath");
		
		return web.verifyPageLoad(wd, text);
		
	}
}
