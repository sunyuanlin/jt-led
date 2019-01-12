package com.yuanjun.bean;

public class DepartMent {
	private String DEPARTMENT_ID;
	private String DEPARTMENT_DESC;
	public String getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(String dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public String getDEPARTMENT_DESC() {
		return DEPARTMENT_DESC;
	}
	public void setDEPARTMENT_DESC(String dEPARTMENT_DESC) {
		DEPARTMENT_DESC = dEPARTMENT_DESC;
	}
	@Override
	public String toString() {
		return "DepartMent [DEPARTMENT_ID=" + DEPARTMENT_ID + ", DEPARTMENT_DESC=" + DEPARTMENT_DESC + "]";
	}
	public DepartMent(String dEPARTMENT_ID, String dEPARTMENT_DESC) {
		super();
		DEPARTMENT_ID = dEPARTMENT_ID;
		DEPARTMENT_DESC = dEPARTMENT_DESC;
	}
	public DepartMent() {
		super();
	}
}	
