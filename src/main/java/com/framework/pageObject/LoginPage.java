package com.framework.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.framework.helper.genericHelper.*;
import static com.framework.execution.Keywords.*;
import static com.framework.testbase.TestBase.*;

public class LoginPage {
	
	final static Logger log = Logger.getLogger(LoginPage.class);
	
	String xuname=rdProf.getProperty("Loginuser");
	String xpaswod=rdProf.getProperty("Loginpassword");
	String xloginbutton=rdProf.getProperty("Loginbutton");
	String xlogoutButton=rdProf.getProperty("Logoutbutton");
	String xdashBoardLink=rdProf.getProperty("VerifyDashboardIcon");
		
	
	public void enterUserName(String userName) throws IOException{
		log.info("entering username...."+userName);
		keyword("enter",xuname,userName);
	}
	
	public void enterPassword(String passWord) throws IOException{
		log.info("entering password...."+passWord);
		keyword("enter",xpaswod,passWord);
	}
	
	public void enterLogin() throws IOException{
		log.info("clicking on sign in button....");
		keyword("click",xloginbutton, null);
	}
	
	public void logOut() throws IOException{
		
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			keyword("click",xlogoutButton, null);
				
			log.info("User Logged out from DSP successfully");
		}
		
	public boolean verifySuccessLogin(){
		WebElement verifyDashboardlink=driver.findElement(By.xpath(xdashBoardLink));
		return new GenericHelper().isDisplayed(verifyDashboardlink);
	}
	
	public void loginToApp(String uName, String psWord){
		
		try {
			enterUserName(uName);
			enterPassword(psWord);
			enterLogin();
		}
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
		}
		
	}
	}
	


