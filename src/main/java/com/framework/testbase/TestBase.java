/**
 * 
 */
package com.framework.testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.framework.platforms.DriverSingletoneObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.framework.execution.readPropertiesFile;
import com.framework.helper.excelHelper.excelHelper;

/**
 * @author dashd
 *
 *This is the Base class containing common functionalities used by all pages
 */

public class TestBase {
	
	public static WebDriver driver;
	
	static String configfile = System.getProperty("user.dir")+"/src/main/resources/app_config_Files/"+ "Config.properties";
	static String profileFile = System.getProperty("user.dir")+"/src/main/resources/app_config_Files/"+ "Profile.properties";
	public static String dspurl=readPropertiesFile.read_File(configfile).getProperty("dsp_url");
	
	public static ExtentReports extent;  //We can set path where our report needs to be generated
	public static ExtentTest elog; // where logs needs to be generated
	final static Logger log = Logger.getLogger(TestBase.class);
	public static Properties rdConfig;
	public static Properties rdProf;
	
	@BeforeTest()
	public void loadPropertiesFile(){

		rdConfig= readPropertiesFile.read_File(configfile);
		rdProf= readPropertiesFile.read_File(profileFile);
		
		log.info("Properties File Loaded Successfully");
	} 
	
	@BeforeTest()
	public void extentReports(){
		try{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
		extent.addSystemInfo("Host Name","DSP Software Testing")
		.addSystemInfo("Environment","Automation Testing")
		.addSystemInfo("Username","Debasis");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\"+"extent-config.xml"));
		
		log.info("Extent Report Loaded");
		}
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
		}
	}
	
	@BeforeTest(dependsOnMethods="loadPropertiesFile")
	@Parameters("browser")
	public void setUpApplication(String browser) throws InterruptedException{ // pass browser name 
		System.out.println();
		try{
			driver=DriverSingletoneObject.getInstance(browser);
			driver.manage().window().maximize();
			driver.get(dspurl);
				
			log.info("Application started successfully");
		}
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
		}
		
	}
	/*@BeforeClass(description="Log in to portal")
	public void login() throws InterruptedException{
		try{
						
			keyword("enter",rdProf.getProperty("Loginuser"),"SuperAdmin");
			keyword("enter",rdProf.getProperty("Loginpassword"),"SuperAdmin");
			keyword("click",rdProf.getProperty("Loginbutton"), null);
			
			log.info("User Logged in to DSP successfully");
		}
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
		}
	}
		
	@AfterClass(description="Log out from portal")
	public static void logOut(){
		try{
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			keyword("click",rdProf.getProperty("Logoutbutton"), null);
				
			log.info("User Logged out from DSP successfully");
		}
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
		}
		
	}*/
	
	@AfterTest
	public void closeApplication(){
		try{
//			driver.close();
//			driver.quit();
						
			log.info("Application Closed successfully");
	}
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
	}
	}
	
	@AfterTest
	public void endExtendedReport(){
		extent.flush();
		//extent.close();
	}
	
	
	public String getScreenshot(String imageName){
		String imagelocation=System.getProperty("user.dir")+"/src/main/resources/Test-result/screenshots/";
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(actualImageName);
		try {
			FileUtils.copyFile(image, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actualImageName;
	}
	
	@AfterMethod
	public void getResults(ITestResult result){
		String excelName="testout.xlsx";
		String sheetname="objects";
		String statusHeader="Status";
		String screenShotHeader="Screenshot";
		String excellocation = System.getProperty("user.dir")+"/src/main/resources/Test-result/"+excelName;
		try{
		elog=extent.startTest("Test Result :");
			if (result.getStatus() == ITestResult.SUCCESS) {
			elog.log(LogStatus.PASS, result.getName() + " test is pass");
			
			excelHelper.setResults(excellocation,sheetname,statusHeader,result.getName(),"PASS");
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			elog.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
			excelHelper.setResults(excellocation,sheetname,statusHeader,result.getName(),"SKIP");
		
		} else if (result.getStatus() == ITestResult.FAILURE) {
			elog.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot(result.getName());
			elog.log(LogStatus.FAIL, elog.addScreenCapture(screen));
			excelHelper.setResults(excellocation,sheetname,statusHeader,result.getName(),"FAIL");
			excelHelper.setResults(excellocation,sheetname,screenShotHeader,result.getName(),screen);
			
		} else if (result.getStatus() == ITestResult.STARTED) {
			elog.log(LogStatus.INFO, result.getName() + " test is started");
			excelHelper.setResults(excellocation,sheetname,statusHeader,result.getName(),"STARTED");
			
		}
			log.info("Get results loaded successfully");
			
			extent.endTest(elog);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Object[][] getData(String excelName, String sheetName){
		
		String excellocation = System.getProperty("user.dir")+"/com.dsp.test/src/main/resources/Test-input/"+excelName;
		
		try {
			return excelHelper.getTableArray(excellocation, sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public static void main(String[] args) throws InterruptedException {
		TestBase obj=new TestBase();
		obj.setUpApplication("Chrome");
	}
	
	
}
