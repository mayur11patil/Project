package com.atmecs.toolsqa.helpers;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;


import com.atmecs.toolsqa.pages.Homepage;
import com.atmecs.toolsqa.utils.VerifyResult;
import com.atmecs.toolsqa.utils.XlsReader;


public class HomepageHelper {
	
	XlsReader xlsReader;
	public HomepageHelper(XlsReader xlsreader) {
		this.xlsReader = xlsreader;
	}
	
	Homepage homePage = new Homepage();
	VerifyResult verify = new VerifyResult();
	
	/*
	 * Verify homepage is loaded or not
	 */
	public boolean verifyHomePage(WebDriver driver) {
		return homePage.isToolsQaLogoDisplay(driver);	
	}
	
	public boolean clickOnLogo(WebDriver driver) {
		return homePage.clickOnToolsQaLogoLink(driver);
	}
	
	/*
	 *Checks the particular product is present on page or not
	 *pass the product list from excelsheet(prod1,prod2,prod3,prod4) etc 
	 *verify all the product details - name, image, price and rating
	 */
	public boolean VerifyProductDetailsOnHomepage(WebDriver driver, int rowId) {
		boolean verifyProduct = true;
		
		String productNames = xlsReader.getCellDataByColumnName("testdata1", "ProductName", rowId);
		System.out.println("readed prod name = "+productNames);
		
		String[] products = productNames.split(",");
		List<String> listOfProducts = Arrays.asList(products);

		for(String productName:listOfProducts) {

			if(!verify.verifyTrue(homePage.isProductNameDispaly(productName, driver), "Verify product is present on homepage")) {
				verifyProduct = false;
			}

			if(!verify.verifyTrue(homePage.isProductImageDispaly(productName, driver), "Verify product Image is present on homepage")) {
				verifyProduct = false;
			}

			if(!verify.verifyTrue(homePage.isProductRatingDispaly(productName, driver), "Verify product Rating is present on homepage")) {
				verifyProduct = false;
			}

			if(!verify.verifyTrue(homePage.isProductPriceDispaly(productName, driver), "Verify product Price is present on homepage")) {
				verifyProduct = false;
			}
		}
		return verifyProduct;
	}
	
}
