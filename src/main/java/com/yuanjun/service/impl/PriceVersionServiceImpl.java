package com.yuanjun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.DepartMent;
import com.yuanjun.bean.Test;
import com.yuanjun.bean.Test1;
import com.yuanjun.bean.Version;
import com.yuanjun.bean.demo;
import com.yuanjun.dao.PriceVersionDao;
import com.yuanjun.dao.TestDao;
import com.yuanjun.dao.VersionDao;
import com.yuanjun.service.PriceVersionService;
import com.yuanjun.service.TestService;
import com.yuanjun.service.VersionService;
@Service
public class PriceVersionServiceImpl implements PriceVersionService {
	
	@Autowired
	private PriceVersionDao dao;

	@Override
	public String insertPriceVersion(String STATION_ID, String EQUIPMENTBIGTYPE, String PRODUCTBIGTYPE, Double PRICE,
			int TIMES, String CR_UID, int VERSION_ID) {
		// TODO Auto-generated method stub
		return dao.insertPriceVersion(STATION_ID, EQUIPMENTBIGTYPE, PRODUCTBIGTYPE, PRICE, TIMES, CR_UID, VERSION_ID);
	}
	




}
