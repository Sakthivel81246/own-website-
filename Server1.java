package com.webpage;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Server1 extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String course=req.getParameter("coursename");
		RequestDispatcher rd=req.getRequestDispatcher("/entrol.html");
		rd.forward(req, res);
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String id=req.getParameter("id");
		String password=req.getParameter("password");
		getset ge=new getset();
		Dbs db=new Dbs();
		ge.setname(id);
		ge.setpassword(password);
		try {
			db.verify(ge);
		}
		catch(Exception e) {
			e.printStackTrace();}
		String name=req.getParameter("name");
		ge.setHumanname(name);
		id=req.getParameter("id");
		password=req.getParameter("password");
		String mobile=req.getParameter("mbl");
		ge.setMobile(mobile);
		String gmail=req.getParameter("gmail");
		ge.setGmail(gmail);
		String course=req.getParameter("course");
		ge.setCourse(course);
		String payment=req.getParameter("payment");
		ge.setPayment(payment);
		String date=req.getParameter("date");
		ge.setDate(date);
		if(db.update(ge)) {
			RequestDispatcher rd=req.getRequestDispatcher("/regpage.html");
			rd.forward(req, res);
			ge.setname("");
			ge.setpassword("");
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("/unreg.html");
			rd.forward(req, res);
			ge.setname("");
			ge.setpassword("");
		}
		
	}
}
