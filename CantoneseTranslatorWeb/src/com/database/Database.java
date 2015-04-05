package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Database {
	
	private static final String USER = "CANTO";
	private static final String PASSWORD = "1234";
	private static final String DB_NAME = "CANTO";
	
	public Connection getConnection(){
		
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		 
		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
 
		}
 
		System.out.println("Oracle JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1522:XE", USER,
					PASSWORD);
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			return connection;
		} else {
			System.out.println("Failed to make connection!");
		}
		
		System.out.println("Connection: "+connection);
		
		return connection;
	}

	public ResultSet runViewQuery(PreparedStatement stmt, Connection con) {
		
		ResultSet rs = null;
	 
	    try {
	    	
	        rs = stmt.executeQuery();
	        if(!rs.isBeforeFirst()){
	        	System.out.println("No data.");
	        }
	        return rs;
	        
	    } catch (SQLException e ) {
	        e.printStackTrace();
	    }
		return rs; 
	    
	}

	public void runInsertQuery(PreparedStatement stmt, Connection con) {
		
		try {
			System.out.println("Trying to insert: ");
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
}