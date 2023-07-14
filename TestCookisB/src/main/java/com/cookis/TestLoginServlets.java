package com.cookis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestLoginServlets extends HttpServlet
{
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
  { 
	res.setContentType("text/html");  
	PrintWriter out= res.getWriter();
	
	req.getRequestDispatcher("link.html").include(req, res); 
	  
	
	String name =req.getParameter("name"); 
	String password =req.getParameter("PassWord"); 
	
	if(password.equals("admin@123"))
	{
	  out.print("you are logging succesdFully in !");	 
	  out.print("you are welcome" +name);
	
	 Cookie ck= new Cookie("name", name);
	 res.addCookie(ck);  
    }else {
     out.print("sorry, username or password error!");
     req.getRequestDispatcher("login.html").include(req, res);
    
    }
	  out.close();  
    }
  
}
