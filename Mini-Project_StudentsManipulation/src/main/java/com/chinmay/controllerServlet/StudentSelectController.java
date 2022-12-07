package com.chinmay.controllerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinmay.dto.StudentDTO;
import com.chinmay.service.IStudentService;
import com.chinmay.service.StudentService;

	@SuppressWarnings("serial")
	@WebServlet("/select")
	public class StudentSelectController extends HttpServlet
	{
		StudentService ss;
		public void init()
		{
			try {
				ss=new StudentService();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			PrintWriter pw=resp.getWriter();
			resp.setContentType("text/html");
			
			
			try {
				String str=ss.getDetails();
				pw.println(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pw.println("Problem in Student Registration");
			}
			
			pw.println("<a href='input.html'>HOME</a>");
		}
		
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
}
