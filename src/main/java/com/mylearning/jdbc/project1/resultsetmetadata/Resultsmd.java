package com.mylearning.jdbc.project1.resultsetmetadata;


/*
 * get metadata like total no.of column,column name,column type
 */
import java.sql.*;

public class Resultsmd {

	public static void main(String[] args) {
		// set jdbc driver name and database url
		String url = "jdbc:mysql://localhost:3306/mydatabase";

		// set database credentials
		String uname = "root";
		String pass = "rootrootrootroot";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database..");
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps= con.prepareStatement("select * from employee");
			ResultSet rs =ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("Total columns: "+rsmd.getColumnCount());  
			System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
			System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1)); 
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
