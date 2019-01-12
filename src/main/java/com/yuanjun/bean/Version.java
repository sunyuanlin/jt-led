package com.yuanjun.bean;

import java.sql.Date;

public class Version {
	private int ID;
	private String VERSION;
	private String ADDRESS;
	private Date C_TIME;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getVERSION() {
		return VERSION;
	}
	public void setVERSION(String vERSION) {
		VERSION = vERSION;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public Date getC_TIME() {
		return C_TIME;
	}
	public void setC_TIME(Date c_TIME) {
		C_TIME = c_TIME;
	}
	@Override
	public String toString() {
		return "Version [ID=" + ID + ", VERSION=" + VERSION + ", ADDRESS=" + ADDRESS + ", C_TIME=" + C_TIME + "]";
	}
	public Version(int iD, String vERSION, String aDDRESS, Date c_TIME) {
		super();
		ID = iD;
		VERSION = vERSION;
		ADDRESS = aDDRESS;
		C_TIME = c_TIME;
	}
	public Version() {
		super();
	}
	
}
