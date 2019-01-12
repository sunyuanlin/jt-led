package com.yuanjun.bean;

public class Test1 {
	private String OPERATION_NAME;
	private String EQUIPMENT_UNIT;
	private String PRODUCT_NAME;
	private String CUSTOMER_LOT_NO;
	private String MOVE_OUT_QTY1;
	
	public Test1(String oPERATION_NAME, String eQUIPMENT_UNIT, String pRODUCT_NAME, String cUSTOMER_LOT_NO,
			String mOVE_OUT_QTY1) {
		super();
		OPERATION_NAME = oPERATION_NAME;
		EQUIPMENT_UNIT = eQUIPMENT_UNIT;
		PRODUCT_NAME = pRODUCT_NAME;
		CUSTOMER_LOT_NO = cUSTOMER_LOT_NO;
		MOVE_OUT_QTY1 = mOVE_OUT_QTY1;
	}

	@Override
	public String toString() {
		return "Test1 [OPERATION_NAME=" + OPERATION_NAME + ", EQUIPMENT_UNIT=" + EQUIPMENT_UNIT + ", PRODUCT_NAME="
				+ PRODUCT_NAME + ", CUSTOMER_LOT_NO=" + CUSTOMER_LOT_NO + ", MOVE_OUT_QTY1=" + MOVE_OUT_QTY1 + "]";
	}

	public String getOPERATION_NAME() {
		return OPERATION_NAME;
	}

	public void setOPERATION_NAME(String oPERATION_NAME) {
		OPERATION_NAME = oPERATION_NAME;
	}

	public String getEQUIPMENT_UNIT() {
		return EQUIPMENT_UNIT;
	}

	public void setEQUIPMENT_UNIT(String eQUIPMENT_UNIT) {
		EQUIPMENT_UNIT = eQUIPMENT_UNIT;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getCUSTOMER_LOT_NO() {
		return CUSTOMER_LOT_NO;
	}

	public void setCUSTOMER_LOT_NO(String cUSTOMER_LOT_NO) {
		CUSTOMER_LOT_NO = cUSTOMER_LOT_NO;
	}

	public String getMOVE_OUT_QTY1() {
		return MOVE_OUT_QTY1;
	}

	public void setMOVE_OUT_QTY1(String mOVE_OUT_QTY1) {
		MOVE_OUT_QTY1 = mOVE_OUT_QTY1;
	}

	public Test1() {
		super();
	}
}
