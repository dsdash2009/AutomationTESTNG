package com.framework.pageObject;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.framework.testbase.TestBase;
import static com.framework.execution.Keywords.*;


public class Login extends TestBase {
	
	final static Logger log = Logger.getLogger(Login.class);
	
	@Test(description="Log in to portal")
	public void login() throws InterruptedException{
		
		try{
			
			keyword("enter",rdProf.getProperty("Loginuser"),rdConfig.getProperty("dsp_user"));
			keyword("enter",rdProf.getProperty("Loginpassword"),rdConfig.getProperty("dsp_password"));
			keyword("click",rdProf.getProperty("Loginbutton"), null);
			
			log.info("User Logged in to DSP successfully");
		}
		catch(Exception e){
			log.error("oops!!! something went wrong",e);
		}
		
	}
		
	
}

