package com.cleartrip.utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsUtility {
	
	public String getText(WebElement element) {		
		System.out.println("WebElementsUtility getText: BeginOnly!");
		return element.getText();		
	}
		
	public void fillTextBox(WebElement element, String text) {
		System.out.println("WebElementsUtility fillTextBox: Begin!");
		System.out.println("element is: "+element.toString());
		System.out.println("text is: "+text);
		element.clear();
		element.sendKeys(text);
		System.out.println("WebElementsUtility fillTextBox: End!");
	}
	
	public void fillDropDown(WebElement element, String value) {
		System.out.println("WebElementsUtility fillDropDown: Begin!");
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
				
		System.out.println("WebElementsUtility fillDropDown: End!");
	}

	public void selectRadioButton(WebElement element) {
		System.out.println("WebElementsUtility selectRadioButton: Begin!");
		element.click();
		System.out.println("WebElementsUtility selectRadioButton: End!");
	}
	
	public void clickButton(WebElement element) {
		System.out.println("WebElementsUtility clickButton: Begin!");
		element.click();
		System.out.println("WebElementsUtility clickButton: End!");
	}
	
	public void clickLink(WebElement element) {
		System.out.println("WebElementsUtility clickLink: Begin!");
		element.click();
		System.out.println("WebElementsUtility clickLink: End!");
	}
	
	public void closeBrowser(WebDriver wd) {
		System.out.println("WebElementsUtility closeBrowser: Begin!");
		wd.close();
		System.out.println("WebElementsUtility closeBrowser: End!");
	}
	
	public void quitDriver(WebDriver wd) {
		System.out.println("WebElementsUtility quitDriver: Begin!");
		wd.quit();
		System.out.println("WebElementsUtility quitDriver: End!");
	}
	
	public void selectAjaxValue() {
		
	}
	
	public void waitFor(int durationInMilliSeconds) {
		System.out.println("WebElementsUtility waitFor: Begin!");
		try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
		System.out.println("WebElementsUtility waitFor: End!");
	}
	
	public boolean verifyWebElementLoad(WebDriver wd, String locator) {
		
		System.out.println("WebElementsUtility verifyWebElementLoad: Begin!");
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
	/*
	public boolean verifyWebElementRefreshed(WebDriver wd, String locator) {
		
		System.out.println("WebElementsUtility verifyWebElementRefreshed: Begin!");
		WebDriverWait wait=new WebDriverWait(wd, 20);
		
		boolean pageLoad = false;
				
		//pageLoad= 
		pageLoad =	wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(wd.findElement(By.xpath(locator)))));
		wait = null;
		return pageLoad;
		
	}
*/
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) {
		System.out.println("WebElementsUtility takeSnapShot: Begin!");
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);        
        try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("WebElementsUtility takeSnapShot: End!");
    }
	
	public Set<String> getWindowsList(WebDriver wd) {
		
		Set<String> windowSet = new HashSet<String>();
		
		windowSet= wd.getWindowHandles();
						
		return windowSet;
	}
	
	public void printWindowHandlesName(WebDriver wd) {
		Set<String> windowSets = this.getWindowsList(wd);
		System.out.println("Total window hanadles are: "+windowSets.size());
		Iterator<String> iterator = windowSets.iterator();
		String name;
		int i =0;
		
		while (iterator.hasNext()) {
			i++;
			name = iterator.next();
			System.out.println("Browser "+i+ ", Name is: "+name);
		}
	}
	
	public String getCurrentWindowhandle(WebDriver wd) {
		return wd.getWindowHandle();
	}
	
	
	public void getWindow(WebDriver wd, String windowName) {
		
		Set<String> windowSets = this.getWindowsList(wd);		
		Iterator<String> iterator = windowSets.iterator();
		
		String name;
		
		while (iterator.hasNext()) {
			name = iterator.next();
			if (name.equals(windowName)) {
				
				break;
			}
		}
	}
	
	public void runJavaScriptExecutor(WebDriver wd) {		
		JavascriptExecutor js = (JavascriptExecutor) wd;  
		js.executeScript("document.getElementById('signInButton').click();");
	}
	
}
