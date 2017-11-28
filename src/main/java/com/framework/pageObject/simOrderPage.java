package com.framework.pageObject;

import static com.framework.pageObject.simPackagePage.goToMainMenu;
import static com.framework.testbase.TestBase.*;

import java.io.IOException;
import java.util.List;
import static com.framework.execution.Keywords.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class simOrderPage {

	final static Logger log=Logger.getLogger(simOrderPage.class);
		String xmanageSIMorder=rdProf.getProperty("ManageSIMorder");
		String xNewSIMOrder=rdProf.getProperty("NewSIMOrder");
		String xPurchaseOrder=rdProf.getProperty("PurchaseOrder");
		String xQuantity=rdProf.getProperty("Quantity");
		String xSAPNumber=rdProf.getProperty("SAPNumber");
		
		String xIMSIPool=rdProf.getProperty("IMSIPool");
		String xNFCkey=rdProf.getProperty("NFCkey");
		String xOTACapable=rdProf.getProperty("OTACapable");
		String xOTAcapable=rdProf.getProperty("OTAcapable");
		String xVendorProfile=rdProf.getProperty("VendorProfile]");
		String xPackaging=rdProf.getProperty("Packaging");
		String xTechnicalProf=rdProf.getProperty("TechnicalProf");
		String xArtwork=rdProf.getProperty("Artwork");
		String xSImtype=rdProf.getProperty("SImtype");
		String xSIMtypeIdentifier=rdProf.getProperty("simTypeIdentifier");
		String xMVNO=rdProf.getProperty("MVNO");
		String xMnemonics=rdProf.getProperty("Mnemonics");
		String xSelectDeliveryDate=rdProf.getProperty("SelectDeliveryDate");
		String xSelectDate=rdProf.getProperty("SelectDate");
		String xorderSubmitButton=rdProf.getProperty("orderSubmitButton");
				
	
		public void MainMenu() throws IOException {
		goToMainMenu();
		}
		
		public void clickManageSIMorder() throws IOException {
			keyword("click",xmanageSIMorder, null);
			log.info("Manage SIM order clicked ");
			}
		
		public void clickNewSimorder() throws IOException{
		keyword("click",xNewSIMOrder, null);
		log.info("New SIM order link clicked");
		}
		
		public void enterPurchageOrder() throws IOException{
			keyword("enter",xPurchaseOrder,"PO10001");
			log.info("Purchage order entered");
			}
		
		public void enterOrderQuantity() throws IOException{
			keyword("enter",xQuantity, "100");
			log.info("SIM order quantity entered");
			}
		
		public void selectSAPNumber() throws IOException, InterruptedException{
			keyword("click",xSAPNumber, null);
			keyword("click","//div[@id='commercialSelectId_chzn']//div[1]//li[3]", null);
			
			log.info("SAP Number Selected");
			}

		public void selectIMSIpool() throws IOException{
			keyword("select",xIMSIPool, "5");
			log.info("IMSI Pool Selected");
			}
		
		public void enterNFCbankKey() throws IOException{
			keyword("enter",xNFCkey, null);
			log.info("NFC Bank Key entered");
			}

		public void selectOTACapable() throws IOException{
			keyword("select",xOTAcapable, null);
			log.info("OTA capable option Selected");
			}

		public void selectVendorProfile() throws IOException{
			keyword("select",xVendorProfile, null);
			log.info("Vendor Profile Selected");
			}

		public void selectPackaging() throws IOException{
			keyword("select",xPackaging, null);
			log.info("SIM Package Selected");
			}

		public void selectTechnicalProfile() throws IOException{
			keyword("select",xTechnicalProf, null);
			log.info("Technical Profile Selected");
			}
		
		public void selectArtwork() throws IOException{
			keyword("select",xArtwork, null);
			log.info("Artwork profile Selected");
			}

		public void selectSIMtype() throws IOException{
			keyword("select",xSImtype, null);
			log.info("SIM Type Selected");
			}

		public void selectSIMtypeIdentifier() throws IOException{
			keyword("select",xSIMtypeIdentifier, null);
			log.info("SAP Number Selected");
			}

		public void enterMVNO() throws IOException{
			keyword("enter",xMVNO, "TESTMVNO1");
			log.info("MVNO value entered");
			}
		
		public void enterMnemonics() throws IOException{
			keyword("enter",xMnemonics, "TESTMNEM1");
			log.info("MNEMONICS value entered");
			}
		
		public void selectDeliveryDate(String Deldate) throws IOException, InterruptedException{

			keyword("click",xSelectDeliveryDate, null);
			
			List<WebElement> allDates=driver.findElements(By.xpath(xSelectDate));

			for (WebElement ele: allDates){
			   if (ele.getText().equals(Deldate)){
			      ele.click();
			      break;
			 }
			}
			log.info("Delivery Date selected");
			}	

		public void clickCreateOrder() throws IOException{
			keyword("click",xorderSubmitButton, null);
			log.info("Create order clicked");
			}

		
		public void createNewOrder(){
			try {
				goToMainMenu();
				clickManageSIMorder();
				clickNewSimorder();
				enterPurchageOrder();
				enterOrderQuantity();
				selectSAPNumber();
				/*selectIMSIpool();
				enterNFCbankKey();
				selectOTACapable();
				selectVendorProfile();
				selectPackaging();
				selectTechnicalProfile();
				selectArtwork();
				selectSIMtype();
				selectSIMtypeIdentifier();*/
				//enterMVNO();
				//enterMnemonics();
				selectDeliveryDate("30");
				clickCreateOrder();
				
				
			} catch (Exception e) {
				log.error("oops!!! something went wrong",e);
			}
		}
		
		public boolean searchlatestOrder(){
			try{
			goToMainMenu();
			clickManageSIMorder();
			List<WebElement> orderList=driver.findElements(By.xpath("//table[@id='order']//td[1]"));
			List<WebElement> orderStatusList=driver.findElements(By.xpath("//table[@id='order']//td[10]"));
			
			for (int i = 0; i < orderList.size(); i++) {
				if(orderStatusList.get(i).getText().equalsIgnoreCase("scheduled")){
					log.info("Found Latest Order:"+orderList.get(i).getText()+": "+orderStatusList.get(i).getText());
				}
			}
			return true;
			}
		catch (Exception e) {
			log.error("oops!!! something went wrong",e);
			return false;
		}
			
}
}
