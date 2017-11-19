package com.app.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class readPropertiesFile {
	
	
	static String fpath = System.getProperty("user.dir");
	static String rpath= fpath + "/src/main/resources/app_config_Files/"+ "Config.properties";
	 
	public static Properties read_File(String fpath) {
	
		 try{	
			InputStream ifile = new FileInputStream(fpath);
		
			Properties fpr = new Properties();
			fpr.load(ifile);
			System.out.println("Proporties Fileloaded");
		return fpr;
		
	}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;	
	}

	/*public static void main(String[] args){
		System.out.println(read_PropertiesFile.read_File(rpath).getProperty("username"));
					}*/
	}
	
