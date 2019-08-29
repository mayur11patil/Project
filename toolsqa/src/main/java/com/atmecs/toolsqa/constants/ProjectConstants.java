package com.atmecs.toolsqa.constants;

import java.io.File;

public class ProjectConstants {
	
	public static final String USER_HOME = System.getProperty("user.dir") + File.separator;
	
	public static final String RESOURCES_HOME = USER_HOME + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator;
	
	public static final String TESTDATA_HOME =  RESOURCES_HOME + "testdata" + File.separator;
	
	public static final String LOCATORS_HOME = RESOURCES_HOME + File.separator + "locators" + File.separator;
	
	
	
	
	//.props file
	public static final String HOMEPAGE_LOCATORS = LOCATORS_HOME + File.separator + "homepage.properties";
	public static final String SHOPPAGE_LOCATORS = LOCATORS_HOME + File.separator + "shoppage.properties";
	
	//excel path
	public static final String TEST_DATA_FILE_PATH = RESOURCES_HOME + "testdata" + File.separator + "ToolsQaTestdata.xlsx";
	
	//
	public static final String LOG4J_PROPERTIES_FILE = RESOURCES_HOME + "log4j.properties";
	
}
