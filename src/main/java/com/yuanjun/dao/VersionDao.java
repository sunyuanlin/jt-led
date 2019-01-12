package com.yuanjun.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.Version;

public interface VersionDao {
	public String insertVerion(@Param(value="VERSION") String VERSION,@Param(value="ADDRESS") String ADDRESS);
	
	List<Version> MAXID();
	List<Version> findAll();
/*	public int MAXID(HashMap map);*/
}
