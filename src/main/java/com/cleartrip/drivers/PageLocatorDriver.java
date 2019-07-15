package com.cleartrip.drivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageLocatorDriver{
		
	private static Properties property = null;
	
	public static Properties getPropertyInstance () {
		return property;
	}
		
	public void loadPropertyFile(String fileName) {
		
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\PageLocators\\"+fileName);
			property.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public PageLocatorDriver() {
		if (property == null) {
			property = new Properties();
		}
	}
	
	
}
