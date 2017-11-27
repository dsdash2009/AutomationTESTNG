package com.framework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.framework.platforms.DriverSingletoneObject;


public class userMngmntPage {
	
	public static WebDriver driver=DriverSingletoneObject.getInstance("Chrome");
	
	
	public static String usersPage() {

		System.out.println("I have reached User Management Page");
		driver.findElement(By.partialLinkText("Home")).getText();
		driver.findElement(By.id("simStatusPieChart")).getText();
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.className("menuImg"))).perform();
		
		driver.findElement(By.partialLinkText("Manage Users")).click();
		return(driver.getTitle());
		
		
	}
	
	public static void createUser(){
		
		driver.findElement(By.partialLinkText("Create User")).click();
	}

	/*public static void main(String[] args) {
		LoginPage.homePage("http://15.154.113.97:8080/dsp/");
		LoginPage.login("SuperAdmin", "SuperAdmin");
		ManageUsers.usersPage();
		
	}*/

}
