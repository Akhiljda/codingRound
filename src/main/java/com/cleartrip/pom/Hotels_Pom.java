package com.cleartrip.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.common.HandleDate;
import com.cleartrip.dao.Hotels_Dao;
import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;

public class Hotels_Pom {
		
	private PageLocatorDriver prop1 = new PageLocatorDriver();
	private WebElementsUtility web = new WebElementsUtility();			
	private Properties p1 = PageLocatorDriver.getPropertyInstance();
	private WebDriver wd;
	private HandleDate date1 = new HandleDate();
	
	public Hotels_Pom(WebDriver wd) {
		System.out.println("Hotels_Pom: Begin!");
		this.wd = wd;
		prop1.loadPropertyFile("Hotels.properties");
		System.out.println("Hotels_Pom: End!");
	}
	
	public void fillDetailsSearchForHotelsSection(Hotels_Dao hotels_dao) {
		System.out.println("Hotels_Pom: fillDetailsSearchForHotelsSection: Begin!");
		web.fillTextBox(wd.findElement(By.xpath(p1.getProperty("Where_TB_xpath"))), hotels_dao.getWhere());
		
		web.waitFor(3000);
		boolean whereRecordDisplayed = web.verifyWebElementLoad(wd, p1.getProperty("Where_TB_ResultList_Record1_xpath"));

		System.out.println("whereRecordDisplayed? :"+whereRecordDisplayed );
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("Where_TB_ResultList_Record1_xpath"))));
		//
		web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s7.png") ;
		//select from Ajax list
		
		web.waitFor(3000);
		
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("CheckIn_CalenderIcon_xpath"))));		
		date1.selectDate(wd, hotels_dao.getCheckin());
		//fill date calender pop up
		
		web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s8.png") ;
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("CheckOut_CalenderIcon_xpath"))));
				
		date1.selectDate(wd, hotels_dao.getCheckout());
		web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s9.png") ;
		//fill date calender pop up
		web.fillDropDown(wd.findElement(By.xpath(p1.getProperty("Travellers_DD_xpath"))), hotels_dao.getTravellers());
		
		web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s10.png") ;
		System.out.println("Hotels_Pom: fillDetailsSearchForHotelsSection: End!");
	}
	
	public void clickSearchHotelsButton() {
		System.out.println("Hotels_Pom: clickSearchHotelsButton: Begin!");
		web.clickButton(wd.findElement(By.xpath(p1.getProperty("SearchHotels_Btn_xpath"))));
		web.takeSnapShot(wd, "D://TestVagrant//codingRound//Snapshots//s11.png") ;
		System.out.println("Hotels_Pom: clickSearchHotelsButton: End!");
	}
	
	public boolean verifyHotelsPageLoaded(WebDriver wd) {
		System.out.println("Hotels_Pom: verifyHotelsPageLoaded: BeginOnly!");
		String text =p1.getProperty("Travellers_DD_xpath");
		
		return web.verifyWebElementLoad(wd, text);
		
	}
}
