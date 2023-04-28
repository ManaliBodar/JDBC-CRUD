package com.mylearning.jdbc.crudoperation;


import java.util.*;
import java.sql.*;


/*
 * create employee class
 * create method for input field
 * and create employee table using field 
 */

public class Employee {
	private static int empid;
	private static String fname ="";
	private static String lname="";
	private static String mob="";
	private static String designation="";
	private static int salary =0;
	private static String city="";

	
	//generate getter and setter
	
	public static int getEmpid() {
		return empid;
	}
	public static void setEmpid(int empid) {
		Employee.empid = empid;
	}
	public static String getFname() {
		return fname;
	}
	public static void setFname(String fname) {
		Employee.fname = fname;
	}
	public static String getLname() {
		return lname;
	}
	public static void setLname(String lname) {
		Employee.lname = lname;
	}
	public static String getMob() {
		return mob;
	}
	public static void setMob(String mob) {
		Employee.mob = mob;
	}
	public static String getDesignation() {
		return designation;
	}
	public static void setDesignation(String designation) {
		Employee.designation = designation;
	}

	public static int getSalary() {
		return salary;
	}
	
	public static void setSalary(int salary) {
		Employee.salary = salary;
	}
	public static String getCity() {
		return city;
	}
	public static void setCity(String city) {
		Employee.city = city;
	}
	
}
