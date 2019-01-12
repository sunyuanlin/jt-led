package com.yuanjun.bean;

public class Test {
	private String DEPARTMENT_ID;
	private String STATION_DESC;
	private String CALENDAR_SEQ;
	private double MOVE_OUT_QTY;
	

	public Test(String dEPARTMENT_ID, String sTATION_DESC, String cALENDAR_SEQ, double mOVE_OUT_QTY) {
		super();
		DEPARTMENT_ID = dEPARTMENT_ID;
		STATION_DESC = sTATION_DESC;
		CALENDAR_SEQ = cALENDAR_SEQ;
		MOVE_OUT_QTY = mOVE_OUT_QTY;
	}


	@Override
	public String toString() {
		return "Test [DEPARTMENT_ID=" + DEPARTMENT_ID + ", STATION_DESC=" + STATION_DESC + ", CALENDAR_SEQ="
				+ CALENDAR_SEQ + ", MOVE_OUT_QTY=" + MOVE_OUT_QTY + "]";
	}


	public String getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}


	public void setDEPARTMENT_ID(String dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}


	public String getSTATION_DESC() {
		return STATION_DESC;
	}


	public void setSTATION_DESC(String sTATION_DESC) {
		STATION_DESC = sTATION_DESC;
	}


	public String getCALENDAR_SEQ() {
		return CALENDAR_SEQ;
	}


	public void setCALENDAR_SEQ(String cALENDAR_SEQ) {
		CALENDAR_SEQ = cALENDAR_SEQ;
	}


	public double getMOVE_OUT_QTY() {
		return MOVE_OUT_QTY;
	}


	public void setMOVE_OUT_QTY(double mOVE_OUT_QTY) {
		MOVE_OUT_QTY = mOVE_OUT_QTY;
	}


	public Test() {
		super();
	}
}
