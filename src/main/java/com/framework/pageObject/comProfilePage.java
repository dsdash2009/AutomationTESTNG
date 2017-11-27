package com.framework.pageObject;

import org.apache.log4j.Logger;
import static com.framework.execution.Keywords.*;

import java.io.IOException;

import static com.framework.testbase.TestBase.*;
import static com.framework.pageObject.simPackagePage.goToMainMenu;


public class comProfilePage{
	
	final static Logger log = Logger.getLogger(comProfilePage.class);
	
	public void MainMenu() throws IOException {
			goToMainMenu();
			log.info("Main Menu clicked successfully");
			}
	public void clickOnManagePackage() throws IOException{
			keyword("click",rdProf.getProperty("PackageHome"), null);
			log.info("User Reached Package creation Home successfully");
			}
			
	}


