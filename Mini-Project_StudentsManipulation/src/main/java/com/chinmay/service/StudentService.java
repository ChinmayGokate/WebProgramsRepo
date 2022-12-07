package com.chinmay.service;

import java.sql.ResultSet;

import javax.naming.NamingException;

import com.chinmay.bo.StudentBO;
import com.chinmay.dao.IStudentDAO;
import com.chinmay.dao.StudentDAO;
import com.chinmay.dto.StudentDTO;

public class StudentService implements IStudentService 
{
	IStudentDAO sd=null;
	public StudentService() throws NamingException
	{
		sd=new StudentDAO();
	}
	public int setDetails(StudentDTO dto) throws Exception
	{
		int total= dto.getMarks1()+dto.getMarks2()+dto.getMarks3();
		double avg=total/3.0;
		String result=null;
		if(avg<35)
			result="Fail";
		else if(avg<50)
			 result="third class";
		else if(avg<60)
			 result="second class";
		else 
			 result="first class";
		
		StudentBO bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
			int count=sd.insert(bo);
		return count;
		
	}
	public String getDetails() throws Exception
	{
		String str=sd.select();
		return str;
	}
	 
}
