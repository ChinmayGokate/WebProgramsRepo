package com.chinmay.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageApplication extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException
	{
	//set response type
		res.setContentType("text/html");
	//Create object of PrintWrinter
		PrintWriter pw=res.getWriter();
	//read form data (req param value)
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String gender=req.getParameter("gender");
		
		
		if(gender.equalsIgnoreCase("M"))
		{
			if(age>=21)
			{
				pw.println("<h1 style='text-align: center'>Mr "+name+" you are eligible for marriage"+"</h1>");
				
			}
			else
				pw.println("<h1 style='text-align: center'>Mr "+name+" you are not eligible for marriage"+"</h1>");
				
		}
		else
		{
			if(age>=18)
			{
				pw.println("<h1 style='text-align: center'>Miss "+name+" you are eligible for marriage"+"</h1>");
			}
			else
				pw.println("<h1 style='text-align: center'>Miss "+name+" you are not eligible for marriage"+"</h1>");
				
		}
		
		pw.println("<h1 style='text-align: center'><a href='input.html'><img src='image/home.jpeg' width='50' height='50' ></a></h1>");
		pw.close();
	}
}
