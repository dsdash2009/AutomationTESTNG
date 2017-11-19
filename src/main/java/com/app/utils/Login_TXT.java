package com.app.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.testng.annotations.Test;

public class Login_TXT {

	@Test(priority=1)
	public void Write_Text() throws IOException
	{
		String fpath=System.getProperty("user.dir");
		OutputStream ofile= new FileOutputStream(fpath + "/TestData/Csv/" + "Login_TXT.txt",true);		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(ofile));
		bw.write("hello debasis3");
		bw.newLine();
		bw.write("second line4");
		bw.close();
		
	}
		@Test(priority=2)
	public void Read_Text() throws IOException
	{
			String fpath=System.getProperty("user.dir");
			InputStream ifile= new FileInputStream(fpath + "/TestData/Csv/" + "Login_TXT.txt");
			BufferedReader reader= new BufferedReader(new InputStreamReader(ifile));
	
			String cont;
	
			while((cont=reader.readLine())!=null)
			{
				System.out.println(cont);
			}
	}
		
	}
		
	

