package com.yuanjun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.DepartMent;
import com.yuanjun.bean.Price;
import com.yuanjun.bean.Test;
import com.yuanjun.bean.Test1;
import com.yuanjun.bean.Version;
import com.yuanjun.bean.demo;
import com.yuanjun.dao.PriceDao;
import com.yuanjun.dao.PriceVersionDao;
import com.yuanjun.dao.TestDao;
import com.yuanjun.dao.VersionDao;
import com.yuanjun.service.PriceService;
import com.yuanjun.service.PriceVersionService;
import com.yuanjun.service.TestService;
import com.yuanjun.service.VersionService;
@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceDao dao;

	@Override
	public String insertPrice(String STATION_ID, String EQUIPMENTBIGTYPE, String PRODUCTBIGTYPE, Double PRICE,
			int TIMES, String CR_UID, Date CR_DTIME) {
		// TODO Auto-generated method stub
		return dao.insertPrice(STATION_ID, EQUIPMENTBIGTYPE, PRODUCTBIGTYPE, PRICE, TIMES, CR_UID, CR_DTIME);
	}

	@Override
	public List<Price> findAll() {
		// TODO Auto-generated method stub
		List<Price> list = dao.findAll();
		return list;
	}

	@Override
	public String drop() {
		// TODO Auto-generated method stub
		return dao.drop();
	}






}
