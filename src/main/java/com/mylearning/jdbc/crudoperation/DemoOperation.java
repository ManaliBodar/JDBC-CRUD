package com.mylearning.jdbc.crudoperation;

import java.sql.*;
import java.util.*;

public class DemoOperation {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		DemoOperation dop = new DemoOperation();

		int ch = 0;
		do {
			System.out.println("Enter your choice: ");
			System.out.println("1. Inser a new Record: ");
			System.out.println("2. Displaying the Records: ");
			System.out.println("3. Updating the Record: ");
			System.out.println("4. Delete the Record:  ");
			System.out.println("5. Exit");
			ch = sc.nextInt();

			switch (ch) {
			case 1:

				dop.insertData();
				break;
			case 2:
				dop.displayData();
				break;
			case 3:
				dop.updateData();
				break;
			case 4:
				dop.deleteData();
				break;
			case 5:
				System.out.println("Thank you for visiting us.. ");
			default:
				break;
			}
		} while (ch != 5);

	}

	// getconnection for database
	public Connection getConnect() throws SQLException, ClassNotFoundException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database...");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
					"rootrootrootroot");

			return con;

		} catch (SQLException e) {
			System.out.println("SQL Exception occured: " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("class Exception occured: " + e);
		}
		return null;
	}

	// implementing method
	public void insertData() {
		Employee e = new Employee();

		System.out.println("Enter the Employee ID: ");
		int id = sc.nextInt();
		e.setEmpid(id);

		System.out.println("Enter the Employee FirstName: ");
		String fname = sc.next();
		e.setFname(fname);

		System.out.println("Enter the Employee LastName: ");
		String lname = sc.next();
		e.setLname(lname);

		System.out.println("Enter the Employee MobileNumber: ");
		String mobno = sc.next();
		e.setMob(mobno);

		System.out.println("Enter the Employee Designation: ");
		String designation = sc.next();
		e.setDesignation(designation);

		System.out.println("Enter the Employee Salary: ");
		int salary = sc.nextInt();
		e.setSalary(salary);

		System.out.println("Enter the Employee City: ");
		String city = sc.next();
		e.setCity(city);

		try {
			Connection con = getConnect();
			PreparedStatement ps = con.prepareStatement(
					"insert into employee1(emp_Id,emp_Fname,emp_Lname,emp_MobileNo,emp_Designation,emp_Salary,emp_City) values(?,?,?,?,?,?,?)");

			ps.setInt(1, e.getEmpid());
			ps.setString(2, e.getFname());
			ps.setString(3, e.getLname());
			ps.setString(4, e.getMob());
			ps.setString(5, e.getDesignation());
			ps.setInt(6, e.getSalary());
			ps.setString(7, e.getCity());

			int count = ps.executeUpdate();
			ps.close();
			con.close();

			if (count == 1) {
				System.out.println("Record Inserted Successfully.");
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	public void displayData() {
		try {
			Connection con = getConnect();
			PreparedStatement ps = con.prepareStatement("select * from employee1");

			ResultSet rs = ps.executeQuery();
			String userdata = "";
			while (rs.next()) {
				userdata = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " "
						+ rs.getString(5) + " " + rs.getInt(6) + " " + rs.getString(7);
				System.out.println(userdata);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updateData() {
		Employee e = new Employee();
		System.out.println("Enter the Employee ID: ");
		int id = sc.nextInt();
		e.setEmpid(id);

		System.out.println("Enter the Employee FirstName: ");
		String fname = sc.next();
		e.setFname(fname);

		System.out.println("Enter the Employee LastName: ");
		String lname = sc.next();
		e.setLname(lname);

		System.out.println("Enter the Employee MobileNumber: ");
		String mobno = sc.next();
		e.setMob(mobno);

		System.out.println("Enter the Employee Designation: ");
		String designation = sc.next();
		e.setDesignation(designation);

		System.out.println("Enter the Employee Salary: ");
		int salary = sc.nextInt();
		e.setSalary(salary);

		System.out.println("Enter the Employee City: ");
		String city = sc.next();
		e.setCity(city);

		try {
			Connection con = getConnect();
			String query = "update employee set emp_Fname = ?, emp_Lname = ?,emp_MobileNo=? ,emp_Designation =?,emp_Salary=?,emp_City=? where emp_Id=? ";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, e.getEmpid());
			ps.setString(2, e.getFname());
			ps.setString(3, e.getLname());
			ps.setString(4, e.getMob());
			ps.setString(5, e.getDesignation());
			ps.setInt(6, e.getSalary());
			ps.setString(7, e.getCity());

			int count = ps.executeUpdate();
			if (count != 0) {
				System.out.println(count + " record updated.");
			} else {
				System.out.println(" record updation failed.");
			}

			ps.close();
			con.close();

		} catch (Exception e3) {
			System.out.println(e3);
		}
	}

	public void deleteData() {
		Employee e = new Employee();
		int emp_id = 0;
		if (sc != null) {
			System.out.print("Enter EmployeeID you want to delete: ");
			emp_id = sc.nextInt();
		}

		e.setEmpid(emp_id);
		try {

			Connection con = getConnect();
			PreparedStatement ps = con.prepareStatement("delete  from employee1 where emp_ID= ?");
			ps.setInt(1, e.getEmpid());

			// display result
			int count = ps.executeUpdate();

			ps.close();
			con.close();

			if (count != 0) {
				System.out.println(count + " record deleted successfully.");
			} else {
				System.out.println(" record deletion failed.");
			}

		} catch (Exception e1) {
			System.out.println(e1);
		}
	}

}
