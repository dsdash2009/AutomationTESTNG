/**
 * 
 */
package com.test.regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.framework.testbase.TestBase;
/**
 * @author dashd
 *
 */
@Test
public class VerifyLoginPage extends TestBase {

	@Test(description="Log in to portal")
	public void login() throws InterruptedException{
		
		driver.findElement(By.id("userName")).sendKeys("SuperAdmin");
		driver.findElement(By.name("password")).sendKeys("SuperAdmin");
		driver.findElement(By.name("Submit")).click();
		
		Reporter.log("==========Logged in Successfully===========",true);
		Thread.sleep(3000);
		
	}
		

	@Test(description="Log out from portal",dependsOnMethods="login")
	public static void logOut(){
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Logout")).click();
		Reporter.log("==========Logged out from DSP Successfully==========",true);
	}
	
}
