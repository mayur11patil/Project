package com.atmecs.toolsqa.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.toolsqa.constants.ProjectConstants;
import com.atmecs.toolsqa.helpers.ShoppageHelper;
import com.atmecs.toolsqa.testsuite.Browser;
import com.atmecs.toolsqa.testsuite.TestSuiteBase;
import com.atmecs.toolsqa.utils.CommanUtils;
import com.atmecs.toolsqa.utils.PropertyParser;
import com.atmecs.toolsqa.utils.VerifyResult;
import com.atmecs.toolsqa.utils.XlsReader;

public class TestColorFilter extends TestSuiteBase {
	
	Browser browser = new Browser();
	ShoppageHelper shoppageHelper;
	VerifyResult verify = new VerifyResult();
	XlsReader xlsReader =null;
	
	@BeforeMethod
	public void preSetup() {
		xlsReader = CommanUtils.getXlsReader(ProjectConstants.TEST_DATA_FILE_PATH);
		String webURL=PropertyParser.readEnvOrConfigProperty("shoppage_url");
		System.out.println(webURL);
		shoppageHelper = new ShoppageHelper(xlsReader);
		driver = browser.launchURL(webURL, browserName);
	}
	
	@Test
	public void testColorFilterAndVerifyProduct() {
		int rowId=2;
		
		verify.verifyTrueAndStopTest(shoppageHelper.verifyShoppage(driver), "Verify Shoppage is appears");
		shoppageHelper.navigateToShoppageThroghPageIntion(driver);
		verify.verifyTrueAndStopTest(shoppageHelper.verifyProductByColorFilter(driver,rowId), "Verify after selecting color filter product appears");
	}
	
	@Test
	public void testColorFilterAndVerifyProductError() {
		int rowId=2;
		
		verify.verifyTrueAndStopTest(shoppageHelper.verifyShoppage(driver), "Verify Shoppage is appears");
		shoppageHelper.navigateToShoppageThroghPageIntion(driver);
		verify.verifyTrueAndStopTest(shoppageHelper.verifyProductByColorFilterError(driver,rowId), "Verify after selecting color filter product error message appears");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
