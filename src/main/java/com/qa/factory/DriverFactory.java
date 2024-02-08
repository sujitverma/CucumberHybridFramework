package com.qa.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<>();
	public static String remote_url = "http://localhost:4444";
    public final static int TIMEOUT = 5;
	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 * @throws MalformedURLException 
	 */
	public WebDriver init_driver(String browser) throws MalformedURLException {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        tlDriver.set(new RemoteWebDriver(new URL(remote_url), options));
	        //tlDriver.set(new ChromeDriver(options));
	        System.out.println("Browser Started : Chrome");
			/***
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--headless=new");
			tlDriver.set(new ChromeDriver(options));
			***/
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
