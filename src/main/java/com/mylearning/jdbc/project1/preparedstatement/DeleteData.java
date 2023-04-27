package com.mylearning.jdbc.project1.preparedstatement;

import java.sql.*;
import java.util.*;



public class DeleteData {

	 //1.set database url
		public static String url = "jdbc:mysql://localhost:3306/mydatabase";
		
		//2.set database credentials
		public static String uname="root";
		public static String pass="rootrootrootroot";
				
		public static void main(String[] args) throws SQLException,ClassNotFoundException{
			int emp_id =0;
			int count = 0;
			
		try
		{
			Scanner input = new Scanner(System.in);
			if(input != null)
			{
				System.out.print("Enter EmployeeID you want to delete: ");
				emp_id = input.nextInt();
			}
			
			//preparing delete query
			String query = "delete from employee where id=?";
			
			//register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish connection
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			//create JDBC sttaement object
			 System.out.println("preparing query....");
			 PreparedStatement ps = con.prepareStatement(query);
			
			 ps.setInt(1, emp_id);
			
			//display result
			 count = ps.executeUpdate();
			if(count != 0)
			{
				System.out.println(count + " record deleted.");
			}
			else
			{
				System.out.println(" record deletion failed.");
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
