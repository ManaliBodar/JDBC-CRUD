package com.mylearning.jdbc.project1.databasemetadata;

/*
 *provide information like database product,name,version
 *drivername,total no of tables,total number of view 
 */
import java.sql.*;

public class Dbmd {

		public static void main(String[] args) {
			// set jdbc driver name and database url
			String url = "jdbc:mysql://localhost:3306/mydatabase";

			// set database credentials
			String uname = "root";
			String pass = "rootrootrootroot";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database..");
			Connection con = DriverManager.getConnection(url, uname, pass);
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
