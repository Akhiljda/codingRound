package com.cleartrip.drivers;

import org.apache.log4j.Logger;



//import org.apache.logging.log4j.Logger;

public class LoggerDriver {

	private static  Logger logger = null;
	
	public static Logger getInstance() {
		 
		if (logger == null) {
			logger = Logger.getLogger("PropertiesConfig");
		}
						
		return logger;
	}
	
	private LoggerDriver() {
		
	}
	
	
}
