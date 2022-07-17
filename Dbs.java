package com.webpage;

import java.sql.*;

public class Dbs {
	static String name="root";
	static String pass="root";
	static String url="jdbc:mysql://localhost:3306/bankmange";
	static String driver="com.mysql.jdbc.Driver";
	
	public static Connection connection() {
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,name,pass);
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
		return con;
	}
	public boolean create(getset ge) {
		boolean status=false;
		try{
			Connection con=connection();
			String query="insert into bank1 values(?,?);";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1,ge.getname());
			pt.setString(2,ge.getpassword());
			pt.executeUpdate();
			System.out.print("updated..!");
			con.close();
			status=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public boolean verify(getset ge) {
		boolean status=false;
		try{
			Connection con=connection();
			String query= "select name,password from bank1 where name=? and password=?;";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1,ge.getname());
			pt.setString(2,ge.getpassword());
			ResultSet rs=pt.executeQuery();
			if(rs.next()) {
				status=true;
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public boolean update(getset ge) {
		boolean status=false;
		try{
			Connection con=connection();
			String query="insert into enroll values(?,?,?,?,?,?,?,?);";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1,ge.getHumanname());
			pt.setString(2,ge.getname());
			pt.setString(3,ge.getpassword());
			pt.setString(4,ge.getMobile());
			pt.setString(5,ge.getGmail());
			pt.setString(6,ge.getCourse());
			pt.setString(7,ge.getPayment());
			pt.setString(8,ge.getDate());
			pt.executeUpdate();
			System.out.print("updated..!");
			con.close();
			status=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	}
	
	/*
	 * public static void main(String args[]) { try { Connection con=connection();
	 * System.out.print("connected"+" "+ con); } catch(Exception e) {
	 * e.printStackTrace(); System.out.println("not connected"); } }
	 */

