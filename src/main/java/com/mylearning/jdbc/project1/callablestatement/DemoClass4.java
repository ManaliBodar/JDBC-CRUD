package com.mylearning.jdbc.project1.callablestatement;

import java.sql.*;

public class DemoClass4 {

	public static void main(String[] args) {

		//step1: set jdbc driver name and database url
		String url ="jdbc:mysql://localhost:3306/mydatabase";
		
		//set database credentials
		String uname ="root";
		String pass ="rootrootrootroot";
		
		try {
			
			
			//step2:register the jdbc drive
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step3: open a connection
			System.out.println("Connecting to database..");
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			//step4:execute query
			System.out.println("preparing statement..");
			CallableStatement stmt = con.prepareCall("{call INSERTUSER(?,?)}");
			
			stmt.setInt(1, 101);
			stmt.setString(2, "amit");
			
			
			stmt.execute();
			
			System.out.println(" row/s affcted.");
			
			stmt.close();
			con.close();
			
		} 
		catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
