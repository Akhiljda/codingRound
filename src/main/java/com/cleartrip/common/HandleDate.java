package com.cleartrip.common;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cleartrip.drivers.PageLocatorDriver;
import com.cleartrip.utilities.WebElementsUtility;


public class HandleDate {
	
	public Date date1;
	
	WebElement elementMonth;
	WebElement elementYear;
	WebElement elementDate;
	WebElement elementNextMonth;
	List<WebElement> dateElements;
	
	public void selectDate(WebDriver wd, String dateText) {
			
		PageLocatorDriver prop1 = new PageLocatorDriver();
		WebElementsUtility web = new WebElementsUtility();
		
		prop1.loadPropertyFile("DatePicker.properties");
		
		Properties p1 = PageLocatorDriver.getPropertyInstance();
		
		String MonthName_Text_xpath = p1.getProperty("MonthName_Text_xpath");
		String Year_Text_xpath = p1.getProperty("Year_Text_xpath");
		String NextMonth_Btn_xpath = p1.getProperty("NextMonth_Btn_xpath");
		String Dates_List_xpath = p1.getProperty("Dates_List_xpath");
		
		elementNextMonth = wd.findElement(By.xpath(NextMonth_Btn_xpath));
		
		
		try {
			 date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateText);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		
		//0 Jan , 11 Dec
		int monthInt = this.getMonth(c1);
		int yearInt = this.getYear(c1);
		int dateInt = this.getDate(c1);
		
		String monthName = this.getMonthName(monthInt);

		boolean flag = false; 
		
		
		
		do {
			elementMonth = wd.findElement(By.xpath(MonthName_Text_xpath));
			elementYear = wd.findElement(By.xpath(Year_Text_xpath));
			
			if (web.getText(elementYear).equalsIgnoreCase((new Integer(yearInt)).toString()))  {
				if (web.getText(elementMonth).equalsIgnoreCase(monthName)) {
					dateElements = wd.findElements(By.xpath(Dates_List_xpath));
					for (WebElement ele : dateElements ) {
						if(web.getText(ele).equalsIgnoreCase((new Integer(dateInt)).toString())) {
							elementDate = ele;
							break;
						}
					}
				}
				else {
					web.clickButton(elementNextMonth);
					flag = elementNextMonth.isEnabled();												
						
				}
			}
			else {
				web.clickButton(elementNextMonth);
				flag = elementNextMonth.isEnabled();																	
			}
			
		}while(flag == false);
		
	}
	
	public String getMonthName(int monthIndex) {
         return new DateFormatSymbols().getMonths()[monthIndex].toString();
    }
	 
	public int  getMonth(Calendar c1) {		
		return c1.get(Calendar.MONTH);		
	}
	
	public int  getYear(Calendar c1) {		
		return c1.get(Calendar.YEAR);		
	}
	
	public int  getDate(Calendar c1) {		
		return c1.get(Calendar.DATE);		
	}
	
}
