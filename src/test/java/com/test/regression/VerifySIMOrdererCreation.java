/**
 * 
 */
package com.test.regression;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.framework.pageObject.simOrderPage;

/**
 * @author dashd
 *
 */
public class VerifySIMOrdererCreation {
	
	final static Logger log = Logger.getLogger(VerifySIMOrdererCreation.class);

	@Test
	public void verifyNewSIMorder(){
		
		simOrderPage simorder=new simOrderPage();
		
		simorder.createNewOrder();
		if(simorder.searchlatestOrder())
			log.info("New order created successfully");
		else
			log.info("New order creation Failed");
		}
}
