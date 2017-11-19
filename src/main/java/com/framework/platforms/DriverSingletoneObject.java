package com.framework.platforms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingletoneObject {
	
	private static WebDriver driver;
	
	private DriverSingletoneObject(){
		
	}
	
	public static WebDriver getInstance(String browser){
		

		if(driver==null){
			if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
				driver= new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver" , System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe" );
				driver= new FirefoxDriver();}
		}
		return driver;
	}
	
}
