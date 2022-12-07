package com.chinmay.dao;

import com.chinmay.bo.StudentBO;

public interface IStudentDAO 
{
	public int insert(StudentBO bo) throws Exception;
}
