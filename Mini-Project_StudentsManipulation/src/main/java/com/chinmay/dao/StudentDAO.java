package com.chinmay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.chinmay.bo.StudentBO;

public class StudentDAO implements IStudentDAO 
{
	private final static String INSERTQUERY="INSERT INTO STUDENTS VALUES(SEQ1.NEXTVAL,?,?,?,?,?)";
	private final static String SELECTQUERY="SELECT SNO,SNAME,SADD,TOTAL,AVG,RESULT FROM STUDENTS";
	
	DataSource ds=null;
	public StudentDAO() throws NamingException
	{
		InitialContext ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
	}
	
	public int insert(StudentBO bo) throws Exception
	{
		Connection con=getPooledJdbcConnection();
		PreparedStatement ps=con.prepareStatement(INSERTQUERY);
		ps.setString(1, bo.getSname());
		ps.setString(2, bo.getSadd());
		ps.setInt(3, bo.getTotal());
		ps.setDouble(4, bo.getAvg());
		ps.setString(5, bo.getResult());
		
		int result=ps.executeUpdate();
		 ps.close();
		 con.close();
		return result;
		
	}
	public int delete(StudentBO bo) throws Exception
	{
		return 0;
		
	}
	public int update(StudentBO bo) throws Exception
	{
		return 0;
		
	}
	public String select() throws Exception
	{
		Connection con=getPooledJdbcConnection();
		PreparedStatement ps=con.prepareStatement(SELECTQUERY);
		ResultSet rs=ps.executeQuery();
		String str="";
		 while(rs.next())
		 {
			 int sid= rs.getInt(1);
			 String sname=rs.getString(2);
			 String sadd=rs.getString(3);
			 int total=rs.getInt(4);
			 double avg= rs.getDouble(5);
			 String result=rs.getString(6);
			 
			 str=str+" "+sid+" "+sname+" "+sadd+" "+total+" "+avg+" "+result+"<br>";
					 
		 }
		 ps.close();
		 con.close();
		return str;
		
	}
	
	private Connection getPooledJdbcConnection() throws SQLException
	{
		Connection con=ds.getConnection();
		return con;
		
	}
}
