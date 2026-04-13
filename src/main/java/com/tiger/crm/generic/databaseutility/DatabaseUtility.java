package com.tiger.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;

	public void getDatabaseConnection() throws SQLException {
		try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		 conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
		}
		catch(Exception e) {}
	}
	
	public void closeDatabaseConnection() throws SQLException {
		conn.close();
	}
	public ResultSet  executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement stat=conn.createStatement();
		 result=stat.executeQuery(query);
		
		}
		catch(Exception e) {}
		return result;
		
	}
	
	public int  executeNonSelectQuery(String query) throws SQLException {
		int result=0;
		try {
		Statement stat=conn.createStatement();
		 result=stat.executeUpdate(query);
		
		}
		catch(Exception e) {}
		return result;
		
	}
	
	
}
