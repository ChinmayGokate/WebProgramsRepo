package com.chinmay.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/controller")
public class StudentController extends HttpServlet
{
	IStudentService ss;
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
		
		String sname=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		int marks1=Integer.parseInt(req.getParameter("marks1"));
		int marks2=Integer.parseInt(req.getParameter("marks2"));
		int marks3=Integer.parseInt(req.getParameter("marks3"));
		
	
		StudentDTO dto=new StudentDTO();
		dto.setSname(sname);
		dto.setSadd(addrs);
		dto.setMarks1(marks1);
		dto.setMarks2(marks2);
		dto.setMarks3(marks3);
		
		try {
			String result=ss.generateResult(dto);
			pw.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.println("Problem in Student Registration");
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
