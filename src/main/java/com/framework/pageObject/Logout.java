/**
 * 
 */
package com.framework.pageObject;

import static com.framework.execution.Keywords.keyword;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.framework.testbase.TestBase;

/**
 * @author dashd
 *
 */
public class Logout extends TestBase{
	
	final static Logger log = Logger.getLogger(Logout.class);
	
	@Test(description="Logging out from Portal")
	public static void logOut(){
		try{
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			keyword("click",rdProf.getProperty("Logoutbutton"), null);
				
			log.info("User Logged out from DSP successfully");
		}
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
		}
	}	


}
