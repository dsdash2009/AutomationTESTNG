package com.framework.execution;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class readPropertiesFile {
	
	//static String fpath = System.getProperty("user.dir")+"/src/main/resources/app_config_Files/"+ "Config.properties";
 
	 public static Properties read_File( String filepath) {
	
		 try{	
			InputStream ifile = new FileInputStream(filepath);
		
			Properties fpr = new Properties();
			fpr.load(ifile);
			System.out.println("Reading Properties File");
		return fpr;
	}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;	
	}

	/*public static void main(String[] args){
		read_PropertiesFile obj1=new read_PropertiesFile();
		System.out.println(obj1.read_File().getProperty("dsp_user"));
					}*/
	}
	
