package com.chinmay.service;

import java.sql.ResultSet;

import com.chinmay.dto.StudentDTO;

public interface IStudentService 
{
	public int setDetails(StudentDTO dto) throws Exception;
	public String getDetails() throws Exception;
}
