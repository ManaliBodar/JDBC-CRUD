package com.mylearning.jdbc.project1.transcation;

import java.sql.*;
import java.io.*;

public class TranscationManagement2 {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String uname = "root";
		String pass = "rootrootrootroot";

		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			// set autocommit false bcz we do explicitly
			con.setAutoCommit(false);
			
			String query ="insert into employee values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);


			//add input through buffer reader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("Enter employee id: ");
				String s1= br.readLine();
				int id = Integer.parseInt(s1);
				System.out.println("Enter employee firstname: ");
				String fname= br.readLine();
				System.out.println("Enter employee Lastname: ");
				String lname= br.readLine();
				System.out.println("Enter employee Age: ");
				String s4= br.readLine();
				int age = Integer.parseInt(s4);
				
				pst.setInt(1, id);
				pst.setString(2, fname);
				pst.setString(3, lname);
				pst.setInt(4, age);
				
				pst.executeUpdate();
				
				System.out.println("Commit / Rollback");
				String answer = br.readLine();
				if(answer.equals("commit"))
				{
					con.commit();
				}
				if(answer.equals("rollback"))
				{
					con.rollback();
				}
				
				System.out.println("want to add more record y/n");
				String ans = br.readLine();
				if(ans.equals("n"))
				{
					break;
				}
			}
			con.commit();
			System.out.println("record successfully saved.");
			
			con.close();

		} 
		catch (Exception e)
		{
			System.out.println("Exception :" + e);
		}
	}

}
