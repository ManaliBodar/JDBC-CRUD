package com.mylearning.jdbc.project1.transcation;

import java.sql.*;

public class TranscationManagement {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String uname = "root";
		String pass = "rootrootrootroot";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			//set autocommit false bcz we do explicitly
			con.setAutoCommit(false);
			
			Statement st = con.createStatement();
			//st.executeUpdate("insert into user12 values(102,'Bhagi')");
			st.executeUpdate("insert into user12 values(104,'Raja')");
			
			System.out.print("record inserted.");
			con.commit();
			con.close();

		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
	}

}
