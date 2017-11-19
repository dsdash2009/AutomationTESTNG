package com.framework.execution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;

import com.framework.testbase.TestBsae;


public class Parameterization {
	
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String mFilepath = System.getProperty("user.dir")+"/src/main/resources/Test-input/input.xlsx";
	public static WebDriver driver;
	public static String testCaseID;
	final static Logger log = Logger.getLogger(Parameterization.class);
	
// getTableArray() Returns Array of objects from Excel
	
	public static Object[][] getTableArray(String Filepath,String Sheetname) throws IOException{
		String[][] tabArray=null;
		try{
			wbook=new XSSFWorkbook(new File(Filepath));
			sheet =wbook.getSheet(Sheetname);
			
			int startrow=1;
			int startcol=1;
			int ci,cj;
			
			int totalrow= sheet.getLastRowNum();
			int totalcol=sheet.getRow(0).getLastCellNum()-1;
			
			tabArray=new String[totalrow][totalcol];
			ci=0;
			
			for(int i=startrow;i<=totalrow;i++,ci++){
				cj=0;
				for(int j=startcol;j<=totalcol;j++,cj++){
					tabArray[ci][cj]=getCellData(i,j);
				}
			}
		}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
			finally {
				wbook.close();
			}
		return tabArray;
		}
	
	
	// getCellData() Returns Cell value from Excel
	
	public static String getCellData(int Rownum, int Colnum) {
		
		try{
			if(sheet.getRow(Rownum)==null){
				return null;
						}
				else{
					DataFormatter formatter = new DataFormatter();
					return formatter.formatCellValue(sheet.getRow(Rownum).getCell(Colnum));
					}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

// setContent() writes data to a single Cell of Excel based on given rowno and colno 
	public static void setContent(String Filepath,String Sheetname,int rowno,int colno, String celdata) throws IOException{
		FileOutputStream fos=null;
		
		try{
		wbook=new XSSFWorkbook(new FileInputStream(Filepath));
		sheet =wbook.getSheet(Sheetname);
		if(sheet.getRow(rowno)==null){
			Cell setcel=sheet.createRow(rowno).createCell(colno);
			setcel.setCellValue(celdata);
		}
		else{
		Cell setcel=sheet.getRow(rowno).createCell(colno);
		setcel.setCellValue(celdata);
		}
		fos=new FileOutputStream(Filepath);
		wbook.write(fos);
		System.out.println("File written susseccfully ");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	finally{
		wbook.close();
		fos.close();
	}
		
	}
			

// setContent() writes test results to a single Cell of Excel based on given Header, testcaseID, celldata
	public static void setResults(String Filepath,String Sheetname, String Header,String testcaseID,String celdata ) throws IOException{
				
		try{
		wbook=new XSSFWorkbook(new FileInputStream(Filepath));
		sheet =wbook.getSheet(Sheetname);
		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				if(sheet.getRow(0).getCell(j).getStringCellValue().equals(Header) && (sheet.getRow(i).getCell(0).getStringCellValue().contains(testcaseID))){
				log.info("Test status before Execution: "+getCellData(i,j));
				setContent(Filepath,Sheetname,i,j,celdata);
				log.info("Test status After Execution: "+getCellData(i,j));		
				}	
			}
		}
		
	}
		catch(Exception e){
			e.printStackTrace();
		}
	finally{
		wbook.close();
		//fos.close();
	}
		
	}

	public static void main(String[] args) throws IOException{
		//System.out.println(Parameterization.getContent(mFilepath,"Sheet1", 0, 0));
		//ReadExcel_new.setExcellData("Sheet1",5,5,"my data added");
		//System.out.println(getTableArray(mFilepath, "Users"));
		
		Parameterization.setResults(System.getProperty("user.dir")+"/src/main/resources/Test-result/testout.xlsx","Sheet1", "Status","TC_1","PASSED");
		
		
	}
	
}