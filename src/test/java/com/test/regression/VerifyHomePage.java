package com.test.regression;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.framework.execution.Parameterization;
import com.framework.execution.readPropertiesFile;
import com.framework.testbase.TestBsae;

public class VerifyHomePage extends TestBsae{
	static String configfile = System.getProperty("user.dir")+"/src/main/resources/app_config_Files/"+ "Config.properties";
	public static String url=readPropertiesFile.read_File(configfile).getProperty("dsp_url");

@Test(dataProvider="logindata")
public static void verifyHomePage(String user,String pwd){
		System.out.println("HOME PAGE verification started");
		//LoginPage.homePage(url);
		try{
		//assertEquals(LoginPage.login(user, pwd), "Home", "Login Validated successfully");
		}
		catch(Exception e){	
			System.out.println("Login Failed");
		}
		
}
@DataProvider(name="logindata")
public Object[][] datasource() throws IOException{
	Object[][] testObjArray=Parameterization.getTableArray(System.getProperty("user.dir")+
			"/src/main/resources/Test-input/input.xlsx", "Users");
	
	return testObjArray;
}


}
