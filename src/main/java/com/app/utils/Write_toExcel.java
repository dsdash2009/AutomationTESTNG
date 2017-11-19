package com.app.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.IllegalFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_toExcel {
	
	
	public void Excel_Write(String ex, int i) throws IllegalFormatException, IOException {

		String fpath = System.getProperty("user.dir");
		InputStream ofile = new FileInputStream(fpath + "/TestData/Csv/"
				+ "Login_excel.xlsx");

		System.out.println("file loaded");

		Workbook wb = new XSSFWorkbook(ofile);
		System.out.println("workbook loaded");

		Sheet sh1 = wb.getSheet("Sheet1");
		Row rw = sh1.getRow(i);
		if (rw == null)
			sh1.createRow(1).createCell(1).setCellValue("Debasis_null");
		else {
			Cell cl = rw.createCell(2);
			//cl.setCellValue("NewData_not_null");
			cl.setCellValue(ex);
		}
		System.out.println("data ready to write");

		ofile.close();
		OutputStream fos = new FileOutputStream(fpath + "/TestData/Csv/"
				+ "Login_excel.xlsx");
		wb.write(fos);
		fos.close();
		System.out.println("Excel file written");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
