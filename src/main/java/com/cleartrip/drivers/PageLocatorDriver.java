package com.cleartrip.drivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageLocatorDriver{
		
	private Properties property = null;
	
	public Properties getPropertyInstance() {
		return property;
	}
	
	public void loadPropertyFile(String path) {
		
		try {
			FileInputStream fs = new FileInputStream(path);
			property.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	protected PageLocatorDriver() {
		if (property == null) {
			property = new Properties();
		}
	}
	
	
}
