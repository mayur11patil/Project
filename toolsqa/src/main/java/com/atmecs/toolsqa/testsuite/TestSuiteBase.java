package com.atmecs.toolsqa.testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.atmecs.toolsqa.utils.PropertyParser;


public class TestSuiteBase {
	
	protected WebDriver driver;
	protected Browser browser;
	
	protected String browserName = PropertyParser.readEnvOrConfigProperty("browserName");
	
	@BeforeSuite
    public void preSetup() {
        browser = new Browser();
    }

}
