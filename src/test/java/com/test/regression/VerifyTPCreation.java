package com.test.regression;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyTPCreation extends TestBase{
	
	final static Logger log= Logger.getLogger(VerifyTPCreation.class);
	
	
	@Test
	public static void verifyTechProfCreation(){
		
		log.info("Technical Profile created Successfully"+driver.getTitle());
				
	}

}
