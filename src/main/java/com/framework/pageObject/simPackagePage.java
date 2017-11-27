package com.framework.pageObject;

import org.apache.log4j.Logger;
import com.framework.execution.Keywords;

import static com.framework.execution.Keywords.keyword;
import static com.framework.testbase.TestBase.*;

import java.io.IOException;

import com.test.regression.VerifySIMPackege;


public class simPackagePage {
		
		final static Logger log = Logger.getLogger(VerifySIMPackege.class);
		
		private static String xmainMenu=rdProf.getProperty("MainMenu");
		private String xpackageHome=rdProf.getProperty("PackageHome");
		private String xcreateackage=rdProf.getProperty("CreatePackage");
		private String xnewPackage=rdProf.getProperty("PackageName");
		private String xlabellPallet=rdProf.getProperty("LabellPallet");
		private String xsubmitPackage=rdProf.getProperty("SubmitPackage");
		
		
		public static void goToMainMenu() throws IOException {
			keyword("mouseover",xmainMenu, null);
			log.info("Main Menu clicked successfully");
			}
		
		public void clickOnManagePackage() throws IOException {
				Keywords.keyword("click",xpackageHome, null);
				log.info("User re-directing to Package Management Home");
		}
	
		public void goToCreatePackage() throws IOException {
			Keywords.keyword("click",xcreateackage, null);
			log.info("User re-directing to create Package page");
	}
		public void enterPackageDetails(String packageName, String labelpallet) throws IOException{	
					Keywords.keyword("enter",xnewPackage, packageName);
					Keywords.keyword("enter",xlabellPallet, labelpallet);
					
					log.info("User enterred New Package details successfully");
		}
		public void submitPackage() throws IOException{
					Keywords.keyword("click",xsubmitPackage, null);
					log.info("User submitted New Package information");
				}
				
		
		public boolean verifiCreatePackage(){
			return true;
		}
		
		public void createPackage(String packageName,String labelPallet){
			try {
			goToMainMenu();
			clickOnManagePackage();
			goToCreatePackage();
			enterPackageDetails(packageName,labelPallet);
			submitPackage();
			}
			catch(Exception e){
				log.error("oops!!! something went wrong",e);
			}
		
		}
}
