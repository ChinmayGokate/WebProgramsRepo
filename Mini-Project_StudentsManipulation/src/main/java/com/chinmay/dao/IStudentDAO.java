package com.chinmay.dao;

import java.sql.ResultSet;

import com.chinmay.bo.StudentBO;

public interface IStudentDAO 
{
	public int insert(StudentBO bo) throws Exception;
	public int delete(StudentBO bo) throws Exception;
	public int update(StudentBO bo) throws Exception;
	public String select() throws Exception;
}
