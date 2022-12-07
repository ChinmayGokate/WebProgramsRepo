package com.chinmay.bo;

public class StudentBO 
{
	private int sid;
	private String sname;
	private String sadd;
	private int total;
	private double avg;
	private String result;
	
	public int getSid()
	{
		return sid;
	}
	public void setSid(int sid)
	{
		this.sid=sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
