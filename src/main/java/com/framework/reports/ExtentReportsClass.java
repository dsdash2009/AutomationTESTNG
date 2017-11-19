package com.framework.reports;

import java.io.File;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass {
	
	ExtentReports extent;  //We can set path where our report needs to be generated
	ExtentTest logger; // where logs needs to be generated
	

	@BeforeTest()
	public void startTest(){
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
		extent.addSystemInfo("Host Name","DSP Software Testing")
		.addSystemInfo("Environment","Automation Testing")
		.addSystemInfo("Username","Debasis");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\"+"extent-config.xml"));
	
	}

	@Test
	public void passTest(){
		logger=extent.startTest("PAss test");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test case passed");
		
	}
	@Test
	public void failTest(){
		logger=extent.startTest("Fail test");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "TEst case failed");
		
	}
	@Test
	public void skipTest(){
		logger=extent.startTest("Skip test");
		throw new SkipException("Skipping test case, since not ready for testing");
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "TEst case failed is "+result.getName());
			logger.log(LogStatus.FAIL, "TEst case failed is "+result.getThrowable());
			
		}
		else if(result.getStatus()==ITestResult.SKIP){
			logger.log(LogStatus.SKIP,"TEst case skipped is "+result.getName());
		}
		extent.endTest(logger);
	}
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
}
