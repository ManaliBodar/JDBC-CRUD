package com.mylearning.jdbc.project1.databasemetadata;

/*
 * prints total numbers of tables 
 */
import java.sql.*;

public class Dbmd2 {

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
			String table[] = {"TABLE"};
			ResultSet rs = dbmd.getTables(null, null, null, table);
			
			while(rs.next())
			{
				System.out.println(rs.getString(3));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
