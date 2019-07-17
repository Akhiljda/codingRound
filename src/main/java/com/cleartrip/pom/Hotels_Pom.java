package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.dao.Hotels_Dao;
import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class Hotels_Pom {
		
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;
	public Hotels_Pom(WebDriver wd) {
		this.wd = wd;
		prop1.loadPropertyFile("Hotels.properties");			
	}
	
	public void fillDetailsSearchForHotelsSection(Hotels_Dao hotels_dao) {
		
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("Where_TB_xpath"))), hotels_dao.getWhere());
		
		boolean whereRecordDisplayed = web.verifyWebElementLoad(wd, p1.getProperty("From_DD_ResultList_Record1_xpath"));

		System.out.println("whereRecordDisplayed? :"+whereRecordDisplayed );
		//
		//select from Ajax list
			
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("CheckIn_CalenderIcon_xpath"))));
		//fill date calender pop up
		
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("CheckOut_CalenderIcon_xpath"))));
		//fill date calender pop up
		web.fillDropDown(wd.findElement(By.xpath(p1.getProperty("Travellers_DD_xpath"))), hotels_dao.getTravellers());
		
	}
	
	public void clickSearchHotelsButton() {
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("SearchHotels_Btn_xpath"))));
	}
	
	public boolean verifyHotelsPageLoaded(WebDriver wd) {
		
		String text =p1.getProperty("Travellers_DD_xpath");
		
		return web.verifyWebElementLoad(wd, text);
		
	}
}
