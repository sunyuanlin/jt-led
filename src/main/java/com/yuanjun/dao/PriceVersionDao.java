package com.yuanjun.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.Version;

public interface PriceVersionDao {
	public String insertPriceVersion(@Param(value="STATION_ID") String STATION_ID,@Param(value="EQUIPMENTBIGTYPE") String EQUIPMENTBIGTYPE
			,@Param(value="PRODUCTBIGTYPE") String PRODUCTBIGTYPE,@Param(value="PRICE") Double PRICE
			,@Param(value="TIMES") int TIMES,@Param(value="CR_UID") String CR_UID,@Param(value="VERSION_ID") int VERSION_ID);
	
}
