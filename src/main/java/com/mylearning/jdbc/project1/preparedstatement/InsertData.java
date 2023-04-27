package com.mylearning.jdbc.project1.preparedstatement;

import java.sql.*;
import java.util.*;

public class InsertData {
	 //1.set database url
	public static String url = "jdbc:mysql://localhost:3306/mydatabase";
	
	//2.set database credentials
	public static String uname="root";
	public static String pass="rootrootrootroot";

	public static void main(String[] args) throws SQLException,ClassNotFoundException
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter EmployeeID: ");
		int emp_id = input.nextInt();
		System.out.print("Enter Employeename:");
		String emp_fname =input.next();
		System.out.print("Enter EmployeeLastName:");
		String emp_lname = input.next();
		System.out.print("Enter EmployeeAge:");
		int emp_age = input.nextInt();		
		try
		{    
			
			//3.register drive
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//4.open connection
			System.out.println("Connecting to database...");
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			//5.execute query
			System.out.println("preparing query....");
			String query ="insert into employee values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, emp_id);
			ps.setString(2, emp_fname);
			ps.setString(3, emp_lname);
			ps.setInt(4, emp_age);
			
			int count = ps.executeUpdate();
			System.out.println(count + " rows/ inserted.");
			
			//5.close statement and connection
			ps.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception occured: "+e);
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found Exception occured: "+e);
		}
	}
	
}
