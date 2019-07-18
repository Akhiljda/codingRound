package com.cleartrip.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsUtility {
	
	public String getText(WebElement element) {		
		return element.getText();		
	}
		
	public void fillTextBox(WebElement element, String text) {
		
		System.out.println("element is: "+element.toString());
		System.out.println("text is: "+text);
		element.sendKeys(text);
	}
	
	public void fillDropDown(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	public void selectRadioButton(WebElement element) {
		element.click();
	}
	
	public void clickButton(WebElement element) {
		element.click();
	}
	
	public void clickLink(WebElement element) {
		element.click();
	}
	
	public void closeBrowser(WebDriver wd) {
		wd.close();
	}
	
	public void quitDriver(WebDriver wd) {
		wd.quit();
	}
	
	public void selectAjaxValue() {
		
	}
	
	public void waitFor(int durationInMilliSeconds) {
		try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
	}
	
	public boolean verifyWebElementLoad(WebDriver wd, String locator) {
		WebDriverWait wait=new WebDriverWait(wd, 20);
		
		WebElement pageLoad = null;
		pageLoad= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		wait = null;
		if (pageLoad == null) {
			return false;
		}
		else {
			return true;
		}
	}
}
