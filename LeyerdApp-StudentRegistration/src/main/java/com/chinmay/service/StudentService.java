package com.chinmay.service;

import javax.naming.NamingException;

import com.chinmay.bo.StudentBO;
import com.chinmay.dao.IStudentDAO;
import com.chinmay.dao.StudentDAO;
import com.chinmay.dto.StudentDTO;

public class StudentService implements IStudentService 
{
	IStudentDAO dao;
	public StudentService() throws NamingException
	{
		dao=new StudentDAO();
	}
	public String generateResult(StudentDTO dto) throws Exception
	{
		int total= dto.getMarks1()+dto.getMarks2()+dto.getMarks3();
		float avg=total/3.0f;
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
		
			int count=dao.insert(bo);
			
			return count==0?"Student Registration failed":"Student"
					+ " Registration succeded ::"+"total:"+total+" "
							+ "avg::"+avg+" result:"+result;		
		
	}
	
	
}
