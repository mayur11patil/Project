package com.atmecs.toolsqa.helpers;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.atmecs.toolsqa.pages.Shoppage;
import com.atmecs.toolsqa.utils.VerifyResult;
import com.atmecs.toolsqa.utils.XlsReader;

public class ShoppageHelper {

	XlsReader xlsReader;
	public ShoppageHelper(XlsReader xlsReader) {
		this.xlsReader = xlsReader;
	}

	Shoppage shoppage = new Shoppage();
	VerifyResult verify = new VerifyResult();

	public boolean verifyShoppage(WebDriver driver) {
		shoppage.waitForPageLoad(driver);
		return shoppage.isShopHomePageDispaly(driver);
	}

	/*
	 * navigating to shopepage by pageintiton
	 */
	public boolean navigateToShoppageThroghPageIntion(WebDriver driver) {
		return shoppage.clickOnPageInition(driver);
	}

	/*
	 * Verify after selecting filter - color 
	 * product is appears or not
	 */
	public boolean verifyProductByColorFilter(WebDriver driver,int rowId) {

		String colorName = xlsReader.getCellDataByColumnName("testdata1", "FIlterByColor", rowId);
		System.out.println("read color filter "+colorName);
		shoppage.selectColorOfProduct(driver, colorName);
		return shoppage.isProductNameDispaly(driver);

	}

	public boolean verifyProductByColorFilterError(WebDriver driver,int rowId) {

		String colorName = xlsReader.getCellDataByColumnName("testdata1", "FIlterByColor", rowId);
		System.out.println("read color filter "+colorName);
		shoppage.selectColorOfProduct(driver, colorName);
		return shoppage.isProductErrorDisplay(driver);

	}

	/*
	 *selecting filter - order by high to low price
	 *checks whether the product list sorted accoeding to high to low price 
	 */
	public boolean verifyProductByOrderHighToLowFilter(WebDriver driver) {

		String order = "Sort by price: high to low";
		List<String> productPriceList = shoppage.getProductPriceList(driver);
		System.out.println("original list :"+productPriceList);
		shoppage.selectOrderOfProduct(driver, order);

		List<String> actualSortedPriceList = shoppage.getProductPriceList(driver);
		System.out.println("actual sorted high to low :"+actualSortedPriceList);
		List<String> expectedSortedPriceList = productPriceList;
		Collections.sort(expectedSortedPriceList, Collections.reverseOrder());
		System.out.println("expected sorted high to low :"+expectedSortedPriceList);

		return expectedSortedPriceList.equals(actualSortedPriceList);
	}


	/*
	 *selecting filter - order by low to high price
	 *checks whether the product list sorted accoeding to low to high price 
	 */
	public boolean verifyProductByOrderLowToHighFilter(WebDriver driver) {

		String order = "Sort by price: low to high";
		List<String> productPriceList = shoppage.getProductPriceList(driver);
		System.out.println("original list :"+productPriceList);

		shoppage.selectOrderOfProduct(driver, order);

		List<String> actualSortedPriceList = shoppage.getProductPriceList(driver);
		System.out.println("actual sorted high to low :"+actualSortedPriceList);
		List<String> expectedSortedPriceList = productPriceList;
		Collections.sort(expectedSortedPriceList);
		System.out.println("expected sorted high to low :"+expectedSortedPriceList);

		return expectedSortedPriceList.equals(actualSortedPriceList);
	}


}
