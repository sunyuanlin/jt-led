package com.yuanjun.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.DepartMent;
import com.yuanjun.bean.Test;
import com.yuanjun.bean.Test1;
import com.yuanjun.bean.demo;
import com.yuanjun.dao.TestDao;
import com.yuanjun.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao dao;

	@Override
	public List<Test> findAll(String startDate, String endDate) {
		// TODO Auto-generated method stub
		List<Test> list = dao.findAll(startDate, endDate);

		
		
		
		return list;
	}

	@Override
	public List<Test> detail(String startDate, String endDate, String departMent) {
		// TODO Auto-generated method stub
		
		List<Test> list = dao.detail(startDate, endDate, departMent);
		return list;
	}

/*	@Override
	public List<Test> detail_a(String startDate, String departMent, String technology) {
		// TODO Auto-generated method stub
		List<Test> list = dao.detail_a(startDate, departMent, technology);
		return list;
	}*/
	
	@Override
	public List<Test1> detail_a() {
		// TODO Auto-generated method stub
		List<Test1> list = dao.detail_a();
		return list;
	}

	@Override
	public List<demo> list() {
		// TODO Auto-generated method stub
		List<demo> list = dao.list();
		return list;
	}

	@Override
	public String findId(String DEPARTMENT_DESC) {
		// TODO Auto-generated method stub
		return dao.findId(DEPARTMENT_DESC);
	}

}
