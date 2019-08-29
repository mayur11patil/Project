package com.atmecs.toolsqa.utils;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.atmecs.toolsqa.constants.ProjectConstants;


public class Logs {
	
	Logger logger = null;
	
	public Logs() {
		getlogger();
		logger = Logger.getLogger(Logs.class.getName());
	}
	
	public void getlogger() {
		PropertyConfigurator.configure(ProjectConstants.LOG4J_PROPERTIES_FILE);	
	}

	public void info(String message){
		logger.info(message);
	}
	
	public void debug(String message){
		
	}
}
