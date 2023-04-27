package com.mylearning.jdbc.project1.preparedstatement;

import java.sql.*;

public class DemoClass3 {

	public static void main(String[] args) throws Exception {

		//step1: set jdbc driver name and database url
				String url ="jdbc:mysql://localhost:3306/mydatabase";
				
				//set database credentials
				String uname ="root";
				String pass ="rootrootrootroot";
				
				try {
					
					String query ="insert into people values(?,?,?,?)";

					//step2:register the jdbc drive
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//step3: open a connection
					System.out.println("Connecting to database..");
					Connection con = DriverManager.getConnection(url,uname,pass);
					
					//step4:execute query
					System.out.println("preparing statement..");
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.setInt(1, 12);
					ps.setString(2, "mohan");
					ps.setString(3, "reddy");
					ps.setInt(4, 741852369);
					
					int count = ps.executeUpdate();
					
					System.out.println(count +" row/s affcted.");
					
					ps.close();
					con.close();
					
				} 
				catch (Exception e) {
					System.out.println(e.toString());
				}

	}

}
