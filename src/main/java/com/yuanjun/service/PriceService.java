package com.yuanjun.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.DepartMent;
import com.yuanjun.bean.Price;
import com.yuanjun.bean.Test;
import com.yuanjun.bean.Test1;
import com.yuanjun.bean.Version;
import com.yuanjun.bean.demo;

public interface PriceService {
	public String insertPrice(@Param(value="STATION_ID") String STATION_ID,@Param(value="EQUIPMENTBIGTYPE") String EQUIPMENTBIGTYPE
			,@Param(value="PRODUCTBIGTYPE") String PRODUCTBIGTYPE,@Param(value="PRICE") Double PRICE
			,@Param(value="TIMES") int TIMES,@Param(value="CR_UID") String CR_UID,@Param(value="CR_DTIME") Date CR_DTIME);
	List<Price> findAll(); 
	public String drop();
}	
