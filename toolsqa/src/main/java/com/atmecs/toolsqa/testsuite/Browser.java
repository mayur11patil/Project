package com.atmecs.toolsqa.testsuite;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import com.atmecs.toolsqa.utils.Logs;


public class Browser {

	WebDriver driver;
	Logs logs = new Logs();

	public boolean openURL(String url, String browserName) {
		boolean isOpenURL = false;
		
		setDriver(browserName);
		this.driver = getDriver();
		isOpenURL = getUrl(url);

		return isOpenURL;
	}

	public boolean getUrl(String url) {
		driver.get(url);
		return true;
	}

	public enum BrowserType {
		FIREFOX, CHROME, IE,EDGE,SAFARI, HEADLESS
	}


	public WebDriver setDriver(String browserName) {
		try
		{
			switch (BrowserType.valueOf(browserName)) {
			case CHROME:{
				System.out.println("in chrome driver setting case :");
				this.driver = setChromeDriver();
				logs.info("Chrome driver set :"+driver);
				break;
			}
			case FIREFOX:
				System.out.println("in Firefox driver setting case :");
				this.driver = setFirefoxDriver();
				logs.info("Firefox driver set: "+driver);
				break;

			case IE:
				System.out.println("in IE driver setting case :");
				this.driver = setInterExplorerDriver();
				logs.info("Internet driver set: "+driver);
			default:
				break;
			}
		}
		catch(NullPointerException ne) {
			System.out.println("browser is null");
			logs.info("browser is null");
		}
		catch(Exception e) {
			logs.info("exception occoured");
		}

		return driver;
	}


	public WebDriver getDriver() {
		return this.driver;
	}

	private WebDriver setChromeDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.chrome.driver", currentdir + "chromedriver.exe");

		return new ChromeDriver();
	}

	private WebDriver setFirefoxDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.gecko.driver", currentdir + "geckodriver.exe");

		return new FirefoxDriver();
	}

	public WebDriver setInterExplorerDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.ie.driver", currentdir + "IEDriverServer.exe");

		return new InternetExplorerDriver();
	}

	public WebDriver launchURL(String webURL, String browserName) {
		
		openURL(webURL, browserName);
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
}
