package com.yuanjun.control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.yuanjun.bean.Price;
import com.yuanjun.bean.Version;
import com.yuanjun.service.PriceService;
import com.yuanjun.service.VersionService;

@Controller
@RequestMapping("/price")
public class PiecePrice {
	
	@Autowired
	private PriceService service;
	
	@Autowired
	private VersionService service1;
	
	@CrossOrigin
	@RequestMapping("/list")
	public String test() {

		return "main";
	}
	
	@CrossOrigin
	@RequestMapping("/notfound")
	public String notfound() {

		return "404";
	}
	
	@CrossOrigin
	@RequestMapping("/upload")
	public String test1() {

		return "upload";
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping("/list/price")
	public List<Object> PriceList() {
		List<Object> asd = new ArrayList<>();
		List<Price> list = service.findAll();
		
		for (int i = 0; i < list.size(); i++) {
			JSONObject  member1=new JSONObject();
			member1.put("STATION_ID", list.get(i).getSTATION_ID());
			member1.put("EQUIPMENTBIGTYPE", list.get(i).getEQUIPMENTBIGTYPE());
			member1.put("PRODUCTBIGTYPE", list.get(i).getPRODUCTBIGTYPE());
			member1.put("PRICE", list.get(i).getPRICE());
			member1.put("CR_UID", list.get(i).getCR_UID());
			member1.put("CR_DTIME", list.get(i).getCR_DTIME());
			asd.add(member1);
		}
		return asd;
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping("/list/version")
	public List<Version> VersionList() {
/*		List<Object> asd = new ArrayList<>();*/
		List<Version> list = service1.findAll();
		
/*		for (int i = 0; i < list.size(); i++) {
			JSONObject  member1=new JSONObject();
			member1.put("STATION_ID", list.get(i).getSTATION_ID());
			member1.put("EQUIPMENTBIGTYPE", list.get(i).getEQUIPMENTBIGTYPE());
			member1.put("PRODUCTBIGTYPE", list.get(i).getPRODUCTBIGTYPE());
			member1.put("PRICE", list.get(i).getPRICE());
			member1.put("CR_UID", list.get(i).getCR_UID());
			member1.put("CR_DTIME", list.get(i).getCR_DTIME());
			asd.add(member1);
		}*/
		return list;
	}
}
