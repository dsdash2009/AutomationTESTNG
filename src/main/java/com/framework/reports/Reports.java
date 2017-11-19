package com.framework.reports;

import static com.framework.reports.Screenshot.*;

import com.framework.execution.Parameterization;

import net.sourceforge.htmlunit.corejs.javascript.ast.Label;

public class Reports {

	/*public static void setXLValues(String sheetName, int columnNo, int rowNo, String xlData) throws {
		
		CellReference cr = new CellReference(entry.getKey());
		
		//WritableSheet ws = wwbCopy.getSheet(sheetName);
		Workbook wb=new XSSFWorkbook();
		Sheet ws=wb.getSheet(sheetName);
		Label le = new Label(columnNo, rowNo, xlData);
		try{
			
			ws.setCe(le);
			if(xlData.equalsIgnoreCase("Fail")){
				getScreenshot(Parameterization.gxpath);
				WritableHyperlink wa = new WritableHyperlink(ws.findCell("Screenshot").getColumn(), rowNo, new File(Screenshot.filePath));
				ws.addHyperlink(wa);
			}
			}catch (Exception e){
				
			}
		}  */               
		
		
		/*public static void setReports(String sheetName, int columnNo, int rowNo, String xlReport){
			
			WritableSheet ws = wwbCopy.getSheet(sheetName);
			Label le = new Label(columnNo, rowNo, xlReport);
			try{
				
				ws.addCell(le);
						
			}catch (Exception e){
				
				System.out.println("XL Report status column ");
				e.printStackTrace();
				
			}*/
			
		}	
	

