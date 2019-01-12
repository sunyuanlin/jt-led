package com.yuanjun.bean;

public class demo {
	private String PRODUCT_NAME;

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	@Override
	public String toString() {
		return "demo [PRODUCT_NAME=" + PRODUCT_NAME + "]";
	}

	public demo(String pRODUCT_NAME) {
		super();
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public demo() {
		super();
	}
}
