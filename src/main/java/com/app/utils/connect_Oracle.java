package com.app.utils;

import java.sql.*;

import com.framework.execution.readPropertiesFile;


public class connect_Oracle {
	static String fpath = System.getProperty("user.dir")+"/src/main/resources/app_config_Files/"+ "Config.properties";
	//String dburl= "jdbc:oracle:thin:@15.154.113.97:1521/orcl";
	static String dburl=readPropertiesFile.read_File(fpath).getProperty("oracle_dburl");
	static String username= readPropertiesFile.read_File(fpath).getProperty("username");
	static String password=readPropertiesFile.read_File(fpath).getProperty("password");
	
	public static ResultSet DB_querry(String querry) throws SQLException, ClassNotFoundException
	{
		
		
		try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(dburl,username,password);   //create connection object
		Statement stmt=con.createStatement();												//create Statement object

		ResultSet rs= stmt.executeQuery(querry);					//execute querry mainly for select/querry statements

		while(rs.next())
			System.out.println(rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getString(3));
			con.close();
		
			return rs;	}
	catch(Exception e){
		e.printStackTrace();
	}
		return null;
	}
		public void dbinsert(){
		String insert= "insert into TEMP1_DSM_USER(USER_ID,LOGIN,FIRST_NAME,LAST_NAME) values('605','tempuser605','firstname605','lastname605')";
		
		try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(dburl,username,password);   //create connection object
		Statement stmt=con.createStatement();	
		
		stmt.execute(insert);	
		con.close();
		}
		catch(Exception e){
			e.printStackTrace();	
		}
	}
//		public static void main(String[] args) throws ClassNotFoundException, SQLException{
//		connect_Oracle obj2=new connect_Oracle();
//		obj2.DB_querry("SELECT * FROM DSM_USERS");
//			
//		}
}

