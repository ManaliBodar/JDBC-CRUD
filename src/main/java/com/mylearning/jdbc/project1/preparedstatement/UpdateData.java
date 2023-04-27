package com.mylearning.jdbc.project1.preparedstatement;

import java.sql.*;
import java.util.*;

public class UpdateData {
	 //1.set database url
	public static String url = "jdbc:mysql://localhost:3306/mydatabase";
	
	//2.set database credentials
	public static String uname="root";
	public static String pass="rootrootrootroot";
			
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		int emp_id=0,emp_age=0;
		String emp_name=null,emp_lname=null;
		int count = 0;
		
	try
	{
		Scanner input = new Scanner(System.in);
		if(input != null)
		{
			System.out.print("Enter EmployeeID you want to Update Record: ");
			emp_id = input.nextInt();
			System.out.print("Enter Employeename to update: ");
			emp_name = input.next();
			System.out.print("Enter EmployeeLastName to update: ");
			emp_lname = input.next();
			System.out.print("Enter EmployeeAge to update: ");
			emp_age=input.nextInt();
		}
		
		//preparing delete query
		String query = "update employee set firstname = ?, lastname = ?,age=? where id=?";
	
		
		//register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish connection
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		//create JDBC sttaement object
		 System.out.println("updating....");
		 PreparedStatement ps = con.prepareStatement(query);
		
		 ps.setInt(4, emp_id);
		 ps.setString(1, emp_name);
		 ps.setString(2, emp_lname);
		 ps.setInt(3, emp_age);
		
		//display result
		 count = ps.executeUpdate();
		if(count != 0)
		{
			System.out.println(count + " record updated.");
		}
		else
		{
			System.out.println(" record updation failed.");
		}
	
		ps.close();
		con.close();
	}
	catch(SQLException e)
	{
		System.out.println(" Exception occured."+e);
	}
	catch (ClassNotFoundException e) {
		System.out.println("Class not found Exception occured: "+e);
	}

}
}
