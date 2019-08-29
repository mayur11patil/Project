package com.atmecs.toolsqa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertyParser {
	
	/**
	 * ResourceBundle.getBundle("config") tells the classloader to load a resource
	 * named "config" with default package (that is, no package). 
	 * It does NOT mean a resource in the current package that has the referencing class.
	 */
	public static ResourceBundle applicationResource = ResourceBundle.getBundle("config");
	
	/**
	 * This method load all the property values
	 * depends on provided file path and returns the loaded property values 
	 * @param filePath
	 * @return property list
	 * @throws IOException
	 */
	public Properties loadProperty(String filePath) throws IOException{
		Properties props = new Properties();
		FileInputStream ip = new FileInputStream(filePath);
		props.load(ip);
		return props;
	}
	
	/**
	 * first pref for env, next for config file
	 * by default config.properties is loaded into the properties object
	 * @param key = used in config file or envirmment variable
	 */
	public static String readEnvOrConfigProperty(String key) {
        String value = System.getProperty(key);
        if (value == null || value.trim().length() == 0) {
            value = applicationResource.getString(key);
        }
        return value;
    }

}


