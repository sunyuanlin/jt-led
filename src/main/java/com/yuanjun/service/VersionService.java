package com.yuanjun.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.DepartMent;
import com.yuanjun.bean.Test;
import com.yuanjun.bean.Test1;
import com.yuanjun.bean.Version;
import com.yuanjun.bean.demo;

public interface VersionService {
	public String insertVerion(@Param(value="VERSION") String VERSION,@Param(value="ADDRESS") String ADDRESS);
	List<Version> MAXID();
	List<Version> findAll();
}	
