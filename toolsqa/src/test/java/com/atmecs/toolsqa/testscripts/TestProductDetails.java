package com.atmecs.toolsqa.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.toolsqa.constants.ProjectConstants;
import com.atmecs.toolsqa.helpers.HomepageHelper;
import com.atmecs.toolsqa.testsuite.Browser;
import com.atmecs.toolsqa.testsuite.TestSuiteBase;
import com.atmecs.toolsqa.utils.CommanUtils;
import com.atmecs.toolsqa.utils.PropertyParser;
import com.atmecs.toolsqa.utils.VerifyResult;
import com.atmecs.toolsqa.utils.XlsReader;

public class TestProductDetails extends TestSuiteBase {
	
	Browser browser = new Browser();
	HomepageHelper homepageHelper;
	VerifyResult verify = new VerifyResult();
	XlsReader xlsReader =null;
	
	@BeforeTest
	public void preSetup() {
		xlsReader = CommanUtils.getXlsReader(ProjectConstants.TEST_DATA_FILE_PATH);
		String webURL=PropertyParser.readEnvOrConfigProperty("application_url");
		System.out.println(webURL);
		homepageHelper = new HomepageHelper(xlsReader);
		driver = browser.launchURL(webURL, browserName);
	}
	
	@Test
	public void testProductDetails() {
		int rowId = 1;
		
		verify.verifyTrue(homepageHelper.verifyHomePage(driver), "Verify ToolsQa homepage appears");
		verify.verifyTrueAndStopTest(homepageHelper.VerifyProductDetailsOnHomepage(driver, rowId), "Verify All the details of product");	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
