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
import com.yuanjun.dao.TestDao;
import com.yuanjun.dao.VersionDao;
import com.yuanjun.service.TestService;
import com.yuanjun.service.VersionService;
@Service
public class VersionServiceImpl implements VersionService {
	
	@Autowired
	private VersionDao dao;

	@Override
	public String insertVerion(String VERSION, String ADDRESS) {
		// TODO Auto-generated method stub
		return dao.insertVerion(VERSION, ADDRESS);
	}

	@Override
	public List<Version> MAXID() {
		// TODO Auto-generated method stub
		List<Version> list = dao.MAXID();
		return list;
	}

	@Override
	public List<Version> findAll() {
		// TODO Auto-generated method stub
		List<Version> list = dao.findAll();
		return list;
	}




}
