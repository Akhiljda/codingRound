package com.cleartrip.drivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDriver {

	private static  Properties property = null;
	
	public static Properties getInstance() {
		 
		if (property == null) {
			property = new Properties();
		}
				
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\GlobalConfig.properties");
			property.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return property;
	}
	
	private ConfigDriver() {
		
	}
	
	
}
