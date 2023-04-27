package com.mylearning.jdbc.project1.selectdata;

import java.sql.*;

public class DemoClass {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String uname = "root";
		String pass = "rootrootrootroot";
		String query = "select * from employee";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			String userdata = "";

			while (rs.next()) {
				userdata = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4);
				System.out.println(userdata);

			}
			// for 1 record
			// String result = rs.getInt(1)+ ": "+rs.getString("firstname");

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
