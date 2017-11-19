/**
 * 
 */
package com.app.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.framework.pageObject.LoginPage;
import com.framework.testbase.TestBsae;

/**
 * @author dashd
 *Verify Broken Links in DSP home page
 */
public class VerifyBrokenLink extends TestBsae{

	@Test
	public void verifyBrokenLink() throws InterruptedException {
		
		LoginPage obj=new LoginPage();
		obj.login();
		
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.className("menuImg"))).perform();
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++){
			WebElement ele= links.get(i);
			String url=ele.getAttribute("href");
			verifyEachLink(url);
		}
	}
	
	public static void verifyEachLink(String linkurl) {
		try{
		URL url=new URL(linkurl);
		
		HttpURLConnection httpconnect= (HttpURLConnection)url.openConnection();
		httpconnect.setConnectTimeout(2000);
		
		httpconnect.connect();
		
		if(httpconnect.getResponseCode()==200)
			System.out.println(url+"--"+httpconnect.getResponseMessage());
		else if(httpconnect.getResponseCode()==httpconnect.HTTP_NOT_FOUND)
			System.out.println(url+"--"+httpconnect.getResponseMessage());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
			
	}

}
