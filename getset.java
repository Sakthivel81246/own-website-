package com.webpage;

public class getset {
	private static String name;
	private static String password;
	private static String humanname;
	private static String date;
	public static String getDate() {
		return date;
	}
	public static void setDate(String date) {
		getset.date = date;
	}
	public static String getHumanname() {
		return humanname;
	}
	public static void setHumanname(String humanname) {
		getset.humanname = humanname;
	}
	private static String mobile;
	private static String gmail;
	private static String course;
	private static String payment;
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		getset.name = name;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		getset.password = password;
	}
	public static String getMobile() {
		return mobile;
	}
	public static void setMobile(String mobile) {
		getset.mobile = mobile;
	}
	public static String getGmail() {
		return gmail;
	}
	public static void setGmail(String gmail) {
		getset.gmail = gmail;
	}
	public static String getCourse() {
		return course;
	}
	public static void setCourse(String course) {
		getset.course = course;
	}
	public static String getPayment() {
		return payment;
	}
	public static void setPayment(String payment) {
		getset.payment = payment;
	}
	public getset() {
		super();
		this.name=name;
		this.password=password;
	}
	public static String getname() {
		return name;
	}
	public static String getpassword() {
		return password;
	}
	public static void setpassword(String newpassword) {
		password=newpassword;
	}
	public static void setname(String newname) {
		name=newname;
	}

}
