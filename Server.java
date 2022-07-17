package com.webpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Server extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String name=req.getParameter("newid");
		String password=req.getParameter("newpass");
		getset ge=new getset();
		Dbs db=new Dbs();
		ge.setname(name);
		ge.setpassword(password);
		int nameint=name.length();
		int passint=password.length();
		if(nameint>3 && passint>3) {
			if(db.create(ge)){
					RequestDispatcher rd=req.getRequestDispatcher("/regpage.html");
					rd.forward(req, res);
					ge.setname("");
					ge.setpassword("");}
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("/unreg.html");
			rd.forward(req, res);
			ge.setname("");
			ge.setpassword("");
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String name=req.getParameter("oldid");
		String password=req.getParameter("oldpass");
		PrintWriter obj=res.getWriter();
		getset ge=new getset();
		Dbs db=new Dbs();
		ge.setname(name);
		ge.setpassword(password);
		int nameint=name.length();
		int passint=password.length();
		if(nameint>3 && passint>3) {
			if(db.verify(ge)) {
				RequestDispatcher rd=req.getRequestDispatcher("/loginedpage.html");
				rd.forward(req, res);
				ge.setname("");
				ge.setpassword("");
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("/incorrect.html");
				rd.forward(req, res);
				ge.setname("");
				ge.setpassword("");
			}
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("/incorrect.html");
			rd.forward(req, res);
			ge.setname("");
			ge.setpassword("");
		}
	}
}
