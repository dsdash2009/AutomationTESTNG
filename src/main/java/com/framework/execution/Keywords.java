package com.framework.execution;

import static com.framework.testbase.TestBase.*;
import static com.framework.reports.TimeTaken.*;
import static com.framework.locators.XpathLocator.*;
import static com.framework.reports.Screenshot.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Keywords {
	
	public static SimpleDateFormat sdf ;
	
	//public static void keyword(String actionContent,String xpath,String value, String expected, int statusRow, int reportStatus) throws  IOException{
	
	public static void keyword(String actionContent,String xpath,String value) throws  IOException{
		
		//String startTimes = sdf.format(new Date().getTime());
		String endTimes =null;

		try{			
			
		switch(actionContent.toLowerCase()){
	 
		
		case "click":
			try{
			getXpathElement(xpath).click();
			endTimes = sdf.format(new Date().getTime());
			
			/*setContent("objects", 9, statusRow, "Pass");	
			setReports("objects", 12, reportStatus, "Element clicked");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/
			
			} catch (Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				/*setContent("objects", 9, statusRow, "Fail");
				setReports("objects", 12, reportStatus, "Element not clicked");
				setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/	
			}
			
			break;
	
		case "enter":
			try{
				
			getXpathElement(xpath).sendKeys(value);
			endTimes = sdf.format(new Date().getTime());

			/*setContent("objects", 9, statusRow, "Pass");
			setReports("objects", 12, reportStatus, "Elements entered");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/


			}catch (Exception e) {
				endTimes = sdf.format(new Date().getTime());

				/*setContent("objects", 9, statusRow, "Fail");
				setReports("objects", 12, reportStatus, "Elements not entered");
				setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));
*/
				getScreenshot(xpath);
				
			}
			
			break;
		
		case "checkcontent":
			

			String actual = getXpathElement(xpath).getText();
			
			endTimes = sdf.format(new Date().getTime());

			
			/*if(actual.equals(expected)){
			setContent("objects", 9, statusRow, "Pass");
			setContent("objects", 7, statusRow, actual);
			setReports("objects", 12, reportStatus, "Content matched");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));
				
		
			}else 
			{
			
			endTimes = sdf.format(new Date().getTime());

			setContent("objects", 9, statusRow, "Fail");
			setContent("objects", 7, statusRow, actual);
			setReports("objects", 12, reportStatus, "Contents mismatched");		
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));

			}*/
			break;
		
		case "dropdown":
			
			WebElement dropdown = getXpathElement(xpath);
			try{
			Select se = new Select(dropdown);
			se.selectByValue(value);
			endTimes = sdf.format(new Date().getTime());

			/*setContent("objects", 9, statusRow, "Pass");
			setReports("objects", 12, reportStatus, "Dropdown works");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));
*/

			}catch(Exception e){
			
			endTimes = sdf.format(new Date().getTime());
	
			/*setContent("objects", 9, statusRow, "Fail");
			setReports("objects", 12, reportStatus, "Dropdown not works");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/

			}
			//se.selectByVisibleText(value);
			break;
			
		case "mouseover":
	
			try{
			Actions action = new Actions(driver);
			
			WebElement mousehover = getXpathElement(xpath);
			action.moveToElement(mousehover).perform();
			
			endTimes = sdf.format(new Date().getTime());

			/*setContent("objects", 9, statusRow, "Pass");
			setReports("objects", 12, reportStatus, "Mouse-hover works");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/

			}catch (Exception e){

				endTimes = sdf.format(new Date().getTime());
				/*setContent("objects", 9, statusRow, "Fail");
				setReports("objects", 12, reportStatus, "Mouse-hover not works");
				setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/
			}
			
			break;
	
		case "windowspopup":	
			
			break;
		
		case "frames":
			
			break;
			
		case "alertaccept":	
			
			Alert alert = driver.switchTo().alert();
			try{
			
			alert.accept();
			endTimes = sdf.format(new Date().getTime());

			/*setContent("objects", 9, statusRow, "Pass");	
			setReports("objects", 12, reportStatus, "Alert works");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/
			
			
			} catch (Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				/*setContent("objects", 9, statusRow, "Fail");
				setReports("objects", 12, reportStatus, "Alert not works");
				setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/
			}
			
			break;
			
		case "alertdismiss":
			
			Alert alert1 = driver.switchTo().alert();
			try{
			alert1.dismiss();
			endTimes = sdf.format(new Date().getTime());

			/*setContent("objects", 9, statusRow, "Pass");
			setReports("objects", 12, reportStatus, "Alert dismissed");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/

			}catch(Exception e){
				
				endTimes = sdf.format(new Date().getTime());
				/*setContent("objects", 9, statusRow, "Fail");
				setReports("objects", 12, reportStatus, "Alert not works");
				setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/
			}
			break;
			
		case "alertgettext":
			
			
			break;
			
		case "alertsendkeys":
			
			Alert alert2 = driver.switchTo().alert();
			try{
			driver.switchTo().alert().sendKeys(value);
			alert2.accept();
			endTimes = sdf.format(new Date().getTime());

			/*setContent("objects", 9, statusRow, "Pass");
			setReports("objects", 12, reportStatus, "Alert sendkeys works");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/

			} catch (Exception e){
			
				endTimes = sdf.format(new Date().getTime());

				/*setContent("objects", 9, statusRow, "Fail");
				setReports("objects", 12, reportStatus, "Alert sendkeys not works");
				setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/
			
			}
			
			break;
			
		case "getsize":
			
			Dimension dimensionSize = driver.findElement(By.xpath(xpath)).getSize();
			
			int dimensionWidth = dimensionSize.width;
			int dimensionHeight = dimensionSize.height;
			
			try{
			
			endTimes = sdf.format(new Date().getTime());
			
				
			/*setContent("objects", 9, statusRow, "Pass");
			setContent("objects", 13, reportStatus, "(" +String.valueOf(dimensionWidth)+" , "+ String.valueOf(dimensionHeight)+ ")");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));
			setReports("objects", 12, reportStatus, "Size works fine");*/
			
			
			
			System.out.println("Dimension width is "+dimensionWidth);
			System.out.println("Dimension height is "+dimensionHeight);
			} catch(Exception e){
				
				endTimes = sdf.format(new Date().getTime());

				/*setContent("objects", 9, statusRow, "Fail");
				setContent("objects", 13, reportStatus, String.valueOf(dimensionWidth)+" , "+ String.valueOf(dimensionHeight));
				setReports("objects", 12, reportStatus, "Size doesn't work");
				setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));
*/

				
			}
			
			break;
			
		case "getlocation":
			
			Point point = driver.findElement(By.xpath(xpath)).getLocation();
			int xLocation = point.x;
			int yLocation = point.y;
			try{
				
			endTimes = sdf.format(new Date().getTime());	
			
			/*setContent("objects", 9, statusRow, "Pass");
			setContent("objects", 13, reportStatus, "(" +String.valueOf(xLocation)+" , "+ String.valueOf(yLocation)+ ")");
			setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));
			setReports("objects", 12, reportStatus, "Location works fine");*/
			
			} catch(Exception e){

				endTimes = sdf.format(new Date().getTime());

				/*setContent("objects", 9, statusRow, "Fail");
				setContent("objects", 13, reportStatus, String.valueOf(xLocation)+" , "+ String.valueOf(yLocation));
				setReports("objects", 12, reportStatus, "Location doesn't work");
				setContent("objects", 11, reportStatus, getCurrentTime(startTimes, endTimes));*/	
				
			}
			break;
			
		case "uploadFile":	
			
			break;
			
		case "toolTip":
			
			break;
			
		case "datePicker":
			
			break;
			
		case "navigate":
			
			driver.navigate().to(value);
			
			break;
			
		case "forward":
			
			System.out.println("started");
			driver.navigate().forward();
			System.out.println("F completed");
			break;
			
		case "back":
			
			driver.navigate().back();
			
			break;
			
		case "refresh":
			System.out.println("started");

			driver.navigate().refresh();
			
			break;
			
		case "checkbox":
			
			break;
			
		case "selectalloption":
			
			break;

        case "gettitle":
			
			String title = driver.getTitle();
			try{
			
			//setContent("objects", 7, statusRow, title);
			}catch(Exception e){
				
				//setContent("objects", 9, statusRow, "Fail");
				
			}
				break;
        
        case "getcurrenturl":		
			
        	String url = driver.getCurrentUrl();
        	try{
        		
        		//setContent("objects", 7, statusRow, url);
        		
        	}catch(Exception e){
        		
        		//setContent("objects", 9, statusRow, "Fail");
        	}
        	
        	break;
        	
		}
		
		
		}catch(Exception e){
			//setContent("objects", 9, statusRow, "Element not Found");			
				
			}
		
	}
	

	
}