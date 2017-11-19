package com.framework.helper.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.framework.execution.readPropertiesFile;

public class DataBase {
	static String configfile = System.getProperty("user.dir")+"/src/main/resources/app_config_Files/"+ "Config.properties";
	static String connection=readPropertiesFile.read_File(configfile).getProperty("oracle_dburl");
	static String userName= readPropertiesFile.read_File(configfile).getProperty("username");
	static String password=readPropertiesFile.read_File(configfile).getProperty("password");
	
	public static Connection con;
	public static Statement stmt;
	
	public Statement getStatement() throws ClassNotFoundException, SQLException{
		try {
			con = DriverManager.getConnection(connection, userName, password);
			stmt = con.createStatement();
			return stmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			con.close();
		}
		return stmt;
	}
	
	public void insertData(String query) throws ClassNotFoundException, SQLException{
		Statement sta = getStatement();
		sta.executeUpdate(query);
	}
	
	public ResultSet getData(String query) throws ClassNotFoundException, SQLException{
		ResultSet data = getStatement().executeQuery(query);
		return data;
	}
	
	public void updateData(String query) throws ClassNotFoundException, SQLException{
		getStatement().executeUpdate(query);
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		ResultSet rs=db.getData("SELECT * FROM DSP_SIM_INVENTORY_DTLS where ICCID=893144030170000198");
		while(rs.next())
			System.out.println(rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getString(3));
			con.close();
	}
}
