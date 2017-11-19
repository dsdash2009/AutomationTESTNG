/**
 * 
 */
package com.test.regression;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.execution.Keywords;
import com.framework.testbase.TestBsae;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author dashd
 *
 */
public class VerifySIMPackege extends TestBsae {
	
	final static Logger log = Logger.getLogger(VerifySIMPackege.class);
	public static Actions action;
	
	@Test
	public void simPackageHome() {
		try{
		
			Keywords.keyword("mouseover",rdProf.getProperty("MainMenu"), null);
			Keywords.keyword("click",rdProf.getProperty("PackageHome"), null);
			
			log.info("User Reached Package creation Home successfully");
	}
		
		
		
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
	}
		
	}
	@Parameters("package")
	@Test(dependsOnMethods="simPackageHome")
	public void createPackage(String packageName){
			try{
					
				Keywords.keyword("click",rdProf.getProperty("CreatePackage"), null);	
				Keywords.keyword("enter",rdProf.getProperty("PackageName"), packageName);
				Keywords.keyword("enter",rdProf.getProperty("LabellPallet"), "test pallet");
				Keywords.keyword("click",rdProf.getProperty("SubmitPackage"), null);
				
				Assert.assertTrue(false);
				log.info("User created New Package successfully");
	}
			
			
			
			catch(Exception e){
				log.error("oops!!! something went wrong",e);
	}
				
	}

}
