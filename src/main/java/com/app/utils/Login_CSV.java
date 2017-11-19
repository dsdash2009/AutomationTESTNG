package com.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Login_CSV {
	

		//@Test(priority=1)
		public void Read_Text() throws IOException
		{
			String fpath=System.getProperty("user.dir");
			InputStream ifile= new FileInputStream(fpath + "/TestData/Csv/" + "Login_TXT.txt");
			CSVReader rd= new CSVReader(new InputStreamReader(ifile));
			
			String[] data;
			
			while((data=rd.readNext())!=null)
					{
				for(int i=0;i<data.length;i++)
				{
					System.out.println(""+data[i]);
				}
				
				System.out.println("");
					}
			
		}
			//@Test
		public void Write_Text() throws IOException
		{
				String fpath=System.getProperty("user.dir");
				OutputStream ofile= new FileOutputStream(fpath + "/TestData/Csv/" + "Login_TXT.txt",true);
				
		boolean aexists=new File("fpath").exists();
		try{
			
		//FileWriter fw= new FileWriter(fpath,true);
		//CSVWriter csvwr=new CSVWriter(fw,',');
		CSVWriter wr= new CSVWriter(new OutputStreamWriter(ofile),',');
		if(!aexists){
			
			String[] cont= "exists dept year".split(" ");
			wr.writeNext(cont);
			wr.close();
			}
		
		for(int i=0;i<=10;i++){
			String[] cont= "notexists rdept ryear".split(" ");

			wr.writeNext(cont);
			wr.close();
		}
		System.out.println("csv write success");
		}
		catch(IOException e){
			System.out.println("ohh error");
		}
		}
}


