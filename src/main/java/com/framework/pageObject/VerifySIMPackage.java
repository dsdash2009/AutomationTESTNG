package com.framework.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.framework.platforms.DriverSingletoneObject;


public class VerifySIMPackage {

	public static WebDriver driver=DriverSingletoneObject.getInstance("Chrome");
	public static Actions action=new Actions(driver);
	
	public static String simPackagePage() {
		System.out.println("I have reached SIM Package Page");
				
		action.moveToElement(driver.findElement(By.className("menuImg"))).perform();
		
		driver.findElement(By.partialLinkText("Manage Packaging")).click();
		return(driver.getTitle());
	}
	public static void createPackage(String Packagename){
		
		System.out.println((driver.getTitle()));
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//a[@href='/dsp/subscriberResourcemgmt/createPackaging.htm']")).click();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		
		action.moveToElement(driver.findElement(By.name("name"))).click().sendKeys(Packagename).build().perform();;
		//action.sendKeys(Packagename);
		//action.build().perform();
		//driver.findElement(By.id("name")).sendKeys(Packagename);
		driver.findElement(By.name("Labels Pallet")).sendKeys("test pallet");
		driver.findElement(By.name("Submit")).click();
				
	}

	/*public static void main(String[] args) {
		LoginPage.homePage("http://15.154.113.97:8080/dsp/");
		LoginPage.login("SuperAdmin", "SuperAdmin");
		System.out.println(ManageSIMPackage.simPackagePage());
		ManageSIMPackage.createPackage("AutoPackage1");
	}*/
}
