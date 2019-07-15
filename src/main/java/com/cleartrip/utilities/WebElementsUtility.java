package com.cleartrip.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementsUtility {
	
	public String getText(WebElement element) {		
		return element.getText();		
	}
		
	public void fillTextBox(WebElement element, String text) {
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
	
	public void closeBrowser() {
		
	}
	
	public void quitDriver() {
		
	}
	
	public void selectAjaxValue() {
		
	}
}
