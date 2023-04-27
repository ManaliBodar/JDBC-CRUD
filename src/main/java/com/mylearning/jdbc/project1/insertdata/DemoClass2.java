package com.mylearning.jdbc.project1.insertdata;

import java.sql.*;

public class DemoClass2 {

	public static void main(String[] args) throws Exception {
		
		//step1: set jdbc driver name and database url
		String url ="jdbc:mysql://localhost:3306/mydatabase";
		
		//set database credentials
		String uname ="root";
		String pass ="rootrootrootroot";
		String query ="insert into employee values(106,'raj','patel',22)";
		
		//step2:register the jdbc drive
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step3: open a connection
		System.out.println("Connecting to database..");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		//step4:execute query
		System.out.println("Creating statement..");
		Statement st = con.createStatement();
		int count =st.executeUpdate(query);
		
		//step5: extract data (from result set)
		System.out.println(count + " rows affected.");
		
		
		//step6:close the environment
		st.close();
		con.close();
	}

}
