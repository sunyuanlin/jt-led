package com.yuanjun.bean;

import java.sql.Date;

public class Price {
	private String STATION_ID;
	private String EQUIPMENTBIGTYPE;
	private String PRODUCTBIGTYPE;
	private Double PRICE;
	private int TIMES;
	private int PIECE_PRICE_ID;
	private String CR_UID;
	private Date CR_DTIME;
	private String UP_UID;
	private Date UP_DTIME;

	
	public Price(String sTATION_ID, String eQUIPMENTBIGTYPE, String pRODUCTBIGTYPE, Double pRICE, int tIMES,
			int pIECE_PRICE_ID, String cR_UID, Date cR_DTIME, String uP_UID, Date uP_DTIME) {
		super();
		STATION_ID = sTATION_ID;
		EQUIPMENTBIGTYPE = eQUIPMENTBIGTYPE;
		PRODUCTBIGTYPE = pRODUCTBIGTYPE;
		PRICE = pRICE;
		TIMES = tIMES;
		PIECE_PRICE_ID = pIECE_PRICE_ID;
		CR_UID = cR_UID;
		CR_DTIME = cR_DTIME;
		UP_UID = uP_UID;
		UP_DTIME = uP_DTIME;
	}


	@Override
	public String toString() {
		return "Price [STATION_ID=" + STATION_ID + ", EQUIPMENTBIGTYPE=" + EQUIPMENTBIGTYPE + ", PRODUCTBIGTYPE="
				+ PRODUCTBIGTYPE + ", PRICE=" + PRICE + ", TIMES=" + TIMES + ", PIECE_PRICE_ID=" + PIECE_PRICE_ID
				+ ", CR_UID=" + CR_UID + ", CR_DTIME=" + CR_DTIME + ", UP_UID=" + UP_UID + ", UP_DTIME=" + UP_DTIME
				+ "]";
	}


	public String getSTATION_ID() {
		return STATION_ID;
	}


	public void setSTATION_ID(String sTATION_ID) {
		STATION_ID = sTATION_ID;
	}


	public String getEQUIPMENTBIGTYPE() {
		return EQUIPMENTBIGTYPE;
	}


	public void setEQUIPMENTBIGTYPE(String eQUIPMENTBIGTYPE) {
		EQUIPMENTBIGTYPE = eQUIPMENTBIGTYPE;
	}


	public String getPRODUCTBIGTYPE() {
		return PRODUCTBIGTYPE;
	}


	public void setPRODUCTBIGTYPE(String pRODUCTBIGTYPE) {
		PRODUCTBIGTYPE = pRODUCTBIGTYPE;
	}


	public Double getPRICE() {
		return PRICE;
	}


	public void setPRICE(Double pRICE) {
		PRICE = pRICE;
	}


	public int getTIMES() {
		return TIMES;
	}


	public void setTIMES(int tIMES) {
		TIMES = tIMES;
	}


	public int getPIECE_PRICE_ID() {
		return PIECE_PRICE_ID;
	}


	public void setPIECE_PRICE_ID(int pIECE_PRICE_ID) {
		PIECE_PRICE_ID = pIECE_PRICE_ID;
	}


	public String getCR_UID() {
		return CR_UID;
	}


	public void setCR_UID(String cR_UID) {
		CR_UID = cR_UID;
	}


	public Date getCR_DTIME() {
		return CR_DTIME;
	}


	public void setCR_DTIME(Date cR_DTIME) {
		CR_DTIME = cR_DTIME;
	}


	public String getUP_UID() {
		return UP_UID;
	}


	public void setUP_UID(String uP_UID) {
		UP_UID = uP_UID;
	}


	public Date getUP_DTIME() {
		return UP_DTIME;
	}


	public void setUP_DTIME(Date uP_DTIME) {
		UP_DTIME = uP_DTIME;
	}


	public Price() {
		super();
	}
	
	
	
}
