package com.atmecs.toolsqa.pages;



import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.toolsqa.constants.ProjectConstants;
import com.atmecs.toolsqa.utils.CommanUtils;
import com.atmecs.toolsqa.utils.Logs;
import com.atmecs.toolsqa.utils.PropertiesUtil;

public class Homepage {

	CommanUtils commanUtils = new CommanUtils();
	Logs report = new Logs();


	static Properties homePage = PropertiesUtil.loadProperty(ProjectConstants.HOMEPAGE_LOCATORS);

	//all getters 
	public String getProductNameLinkXpath(String productName) {
		return homePage.getProperty("product_link").replace("xxxxx", productName);
	}

	public String getProductPriceXpath(String productName) {
		return homePage.getProperty("product_price").replace("xxxxx", productName);
	}

	public String getProductRatingXpath(String productName) {
		return homePage.getProperty("product_rating").replace("xxxxx", productName);
	}

	public String getProductImageXpath(String productName) {
		return homePage.getProperty("product_image").replace("xxxxx", productName);
	}

	//all getters to get xpath
	public String getLogoLinkXpath() {
		return homePage.getProperty("logo_link");
	}

	public String getDressLinkXpath(String dressName) {
		return homePage.getProperty("product_dress_link").replace("xxxxx", dressName);
	}

	public String getProductHeadingXpath() {
		return homePage.getProperty("selected_product_heading");
	}

	public String getColorOfProductXpath() {
		return homePage.getProperty("color_dropdown");
	}

	public String getSizeOfProductXpath() {
		return homePage.getProperty("size_dropdown");
	}

	public String getQuantityOfProductXpath() {
		return homePage.getProperty("color_dropdown");
	}
	public String getAddToCartButtonXpath() {
		return homePage.getProperty("add_to_cart_button");
	}
	public String getGoToCartLogoXpath() {
		return homePage.getProperty("go_to_cart_logo");
	}

	public String getProductNameFromCartXpath(String productName) {
		return homePage.getProperty("product_name_in_cartlist").replace("xxxxx", productName);
	}

	public String getAllProductPriceFromCartXpath() {
		return homePage.getProperty("individual_product_price_fromcart");
	}

	public String getTotalPriceFromCartXpath() {
		return homePage.getProperty("total_price_cart");
	}

	public String getSearchBarXpath() {
		return homePage.getProperty("search_bar");
	}
	public String getSearchTextBoxXpath() {
		return homePage.getProperty("search_textbox");
	}
	public String getRemoveFirstProductIcon() {
		return homePage.getProperty("remove_firstproduct_icon");
	}

	
	//all actions related homepage

	//click action
	public boolean clickOnToolsQaLogoLink(WebDriver driver) {
		boolean isClicked = false;
		if(commanUtils.isElementPresentAndClickable(driver, getLogoLinkXpath())) {
			driver.findElement(By.xpath(getLogoLinkXpath())).click();
			isClicked = true;
		}
		System.out.println("Clicked on Tools Qa Logo :"+isClicked);
		return true;
	}

	//get text action
	public String getProductHeading(WebDriver driver) {
		String heading="";
		if(commanUtils.isElementVisible(driver, getProductHeadingXpath())) {
			heading=driver.findElement(By.xpath(getProductHeadingXpath())).getText();
			System.out.println("selected product heading is :"+heading);
		}
		return heading;
	}

	//visibilty
	public boolean isToolsQaLogoDisplay(WebDriver driver) {
		boolean isDisaplay = false;
		isDisaplay =CommanUtils.isDisplayed(driver, getLogoLinkXpath());

		System.out.println("Toolsqa Logo page isDisplay :"+isDisaplay);
		return isDisaplay;
	}

	//is display methods
	public boolean isProductNameDispaly(String productName,WebDriver driver) {
		boolean isDisplay = false;
		if(commanUtils.isElementVisible(driver, getProductNameLinkXpath(productName))) {
			isDisplay = commanUtils.isDisplayed(driver, getProductNameLinkXpath(productName));
		}
		report.info(productName+" On Homepage is Present :"+isDisplay);
		return isDisplay;
	}

	public boolean isProductImageDispaly(String productName,WebDriver driver) {
		boolean isDisplay = false;
		if(commanUtils.isElementVisible(driver, getProductImageXpath(productName))) {
			isDisplay = commanUtils.isDisplayed(driver, getProductImageXpath(productName));
		}	
		report.info(productName+" Image On Homepage is Present :"+isDisplay);
		return isDisplay;
	}

	public boolean isProductPriceDispaly(String productName,WebDriver driver) {
		boolean isDisplay = false;
		if(commanUtils.isElementVisible(driver, getProductPriceXpath(productName))) {
			isDisplay = commanUtils.isDisplayed(driver, getProductPriceXpath(productName));
		}	
		report.info(productName+" Price On Homepage is Present :"+isDisplay);
		return isDisplay;
	}

	public boolean isProductRatingDispaly(String productName,WebDriver driver) {
		boolean isDisplay = false;
		if(commanUtils.isElementVisible(driver, getProductRatingXpath(productName))) {
			isDisplay = commanUtils.isDisplayed(driver, getProductRatingXpath(productName));
		}	
		report.info(productName+" Ratnig On Homepage is Present :"+isDisplay);
		return isDisplay;
	}

}
