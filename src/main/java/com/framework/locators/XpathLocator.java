package com.framework.locators;

import static com.framework.testbase.TestBase.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XpathLocator {
	
	final static Logger log = Logger.getLogger(XpathLocator.class);
	
	// Re-usability of xpath element
	public static WebElement getXpathElement(String xpath){
		
		try{
		WebDriverWait Ww = new WebDriverWait(driver,10);
		
		return Ww.until(ExpectedConditions.visibilityOfElementLocated(((By.xpath(xpath)))));
		}catch(Exception e){
			
			log.error("oops!!! Not able to find Locator",e);
		}
		return null;
	}
	
}
