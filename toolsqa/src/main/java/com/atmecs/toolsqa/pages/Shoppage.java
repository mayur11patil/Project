package com.atmecs.toolsqa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.atmecs.toolsqa.constants.ProjectConstants;
import com.atmecs.toolsqa.utils.CommanUtils;
import com.atmecs.toolsqa.utils.Logs;
import com.atmecs.toolsqa.utils.PropertiesUtil;

public class Shoppage {
	CommanUtils commanUtils = new CommanUtils();
	Logs report = new Logs();
	
	
	static Properties shopPage = PropertiesUtil.loadProperty(ProjectConstants.SHOPPAGE_LOCATORS);

	//all getters 
	public String getProductNameXpath() {
		return shopPage.getProperty("product_name");
	}
	
	public String getPageintionLinkXpath() {
		return shopPage.getProperty("page_inintion_no_link");
	}
	
	public String getFilterByColorXpath() {
		return shopPage.getProperty("filter_by_color");
	}
	
	public String getFilterByOrderXpath() {
		return shopPage.getProperty("filter_by_order");
	}
	
	public String getProductsPriceXpath() {
		return shopPage.getProperty("products_price");
	}
	
	public String getProductsHome() {
		return shopPage.getProperty("shoppage_products_home");
	}
	
	public String getProductsErrorXpath() {
		return shopPage.getProperty("product_error");
	}
	
	
	//all action
	
	//click action
	public boolean clickOnPageInition(WebDriver driver) {
		boolean isClicked = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
		if(commanUtils.isElementPresentAndClickable(driver, getPageintionLinkXpath())) {
			driver.findElement(By.xpath(getPageintionLinkXpath())).click(); 
			isClicked = true;
		}
		report.info("Click on pageinition link :"+isClicked);
		Reporter.log("Click on pageinition link :"+isClicked);
		return isClicked;
	}
	
	//select dropdown action
	public boolean selectColorOfProduct(WebDriver driver, String colorName) {
		boolean isSelected = false;
		Select dropdown = new Select(driver.findElement(By.xpath(getFilterByColorXpath())));  
		dropdown.selectByVisibleText(colorName);
		report.info("Selected color of product :"+colorName);
		Reporter.log("Selected color of product :"+colorName);
		return isSelected;	
	}
	
	public boolean selectOrderOfProduct(WebDriver driver, String order) {
		boolean isSelected = false;
		Select dropdown = new Select(driver.findElement(By.xpath(getFilterByOrderXpath())));  
		dropdown.selectByVisibleText(order);
		report.info("Selected order of product :"+order);
		Reporter.log("Selected order of product :"+order);
		return isSelected;	
	}
	
	//is visible
	public boolean isProductNameDispaly(WebDriver driver) {
		boolean isDisplay = false;
		if(commanUtils.isElementVisible(driver, getProductNameXpath())) {
			isDisplay = commanUtils.isDisplayed(driver, getProductNameXpath());
		}
		report.info("Product is Present on shoppage :"+isDisplay);
		Reporter.log("Product is Present on shoppage :"+isDisplay);
		return isDisplay;
	}
	public boolean isProductErrorDisplay(WebDriver driver) {
		boolean isDisplay = false;
		if(commanUtils.isElementVisible(driver, getProductsErrorXpath())) {
			isDisplay = commanUtils.isDisplayed(driver, getProductsErrorXpath());
		}
		report.info("Product Error is Present on shoppage :"+isDisplay);
		Reporter.log("Product Error is Present on shoppage :"+isDisplay);
		return isDisplay;
	}
	
	
	public boolean isShopHomePageDispaly(WebDriver driver) {
		boolean isDisplay = false;
		if(commanUtils.isElementVisible(driver, getProductsHome())) {
			isDisplay = commanUtils.isDisplayed(driver, getProductsHome());
		}
		report.info("Shop Homepage is loaded :"+isDisplay);
		Reporter.log("Shop Homepage is loaded :"+isDisplay);
		return isDisplay;
	}
	
	public List<String> getProductPriceList(WebDriver driver){
		List<String> productPrice = new ArrayList<String>();
		
		List<WebElement> priceElements = driver.findElements(By.xpath(getProductsPriceXpath()));
		for(WebElement price : priceElements) {
			productPrice.add(price.getText());
		}
		return productPrice;
	}
	
	public boolean waitForPageLoad(WebDriver driver) {
		commanUtils.isElementVisible(driver, "//p[text()='@ 2020. Copyright TOOLSQA']");
		return true;
	}
	
}
