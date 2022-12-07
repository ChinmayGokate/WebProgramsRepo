package com.chinmay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.chinmay.bo.StudentBO;
import com.chinmay.service.IStudentService;

public class StudentDAO implements IStudentDAO
{
	private final static String InsertData="INSERT INTO STUDENTS VALUES(SEQ1.NEXTVAL,?,?,?,?,?)";
	DataSource dc=null;
	public StudentDAO() throws NamingException
	{
		InitialContext ic= new InitialContext();
		 dc =(DataSource)ic.lookup("java:/comp/env/DsJndi");
	}
	
	public int insert(StudentBO bo) throws Exception
	{
		Connection con=getPooledConnection();
		PreparedStatement ps=con.prepareStatement(InsertData);
		ps.setString(1, bo.getSname());
		ps.setString(2, bo.getSadd());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());
		
		int count=ps.executeUpdate();
		 ps.close();
		 con.close();
		return count;
	}
	private Connection getPooledConnection() throws SQLException
	{
//		InitialContext ic= new InitialContext();
//		DataSource dc =(DataSource)ic.lookup("java:/comp/env/DsJndi");
		Connection con=dc.getConnection();
		return con;
	}
}

