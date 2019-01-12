
package com.yuanjun.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.DepartMent;
import com.yuanjun.bean.Test;
import com.yuanjun.bean.Test1;
import com.yuanjun.bean.demo;

public interface TestDao {

	List<Test> findAll(@Param("startDate") String startDate,@Param("endDate") String endDate); 
	
	List<Test> detail(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("departMent") String departMent); 

/*	List<Test> detail_a(@Param("startDate") String startDate,@Param("departMent") String departMent,@Param("technology") String technology); 
*/
	List<Test1> detail_a();
	
	List<demo> list();
	
	public String findId(String DEPARTMENT_DESC);
}
