package com.yuanjun.control;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yuanjun.bean.DepartMent;
import com.yuanjun.bean.Test;
import com.yuanjun.bean.Test1;
import com.yuanjun.bean.demo;
import com.yuanjun.service.TestService;




@Controller
public class TestControl {
	@Autowired
	private  TestService service;
	
	
	@CrossOrigin
	@RequestMapping(value="/test1&startDate={startDate}&endDate={endDate}&departMent={departMent}", method=RequestMethod.GET)
	@ResponseBody
	public List<Object> test(@PathVariable String startDate, @PathVariable String endDate, @PathVariable String departMent) {
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(departMent);
/*		DepartMent aaa = service.findId(departMent);*/
/*		System.out.println(aaa);*/
		return null;
	}

	@CrossOrigin
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public List<Test1> asd() {
		List<Test1> list = service.detail_a();
		
		return list;
		
		
	}
	

	   public static List<String> getDays(String startTime, String endTime) {

	        // 返回的日期集合
	        List<String> days = new ArrayList<String>();

	        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	        try {
	            Date start = dateFormat.parse(startTime);
	            Date end = dateFormat.parse(endTime);

	            Calendar tempStart = Calendar.getInstance();
	            tempStart.setTime(start);

	            Calendar tempEnd = Calendar.getInstance();
	            tempEnd.setTime(end);
	            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
	            while (tempStart.before(tempEnd)) {
	                days.add(dateFormat.format(tempStart.getTime()));
	                tempStart.add(Calendar.DAY_OF_YEAR, 1);
	            }

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        return days;
	    }
	
	@CrossOrigin
	@RequestMapping(value="/details&startDate={startDate}&endDate={endDate}&departMent={departMent}", method=RequestMethod.GET)
	@ResponseBody
	public List<Object> detail(@PathVariable String startDate, @PathVariable String endDate, @PathVariable String departMent) {
		startDate = startDate.replaceAll("-","");
		endDate = endDate.replaceAll("-","");
		
		List<String> listDay = getDays(startDate, endDate);
		
		List<Test> list = service.detail(startDate, endDate, departMent);
		int a = Integer.parseInt(startDate);
		int b = Integer.parseInt(endDate);
		List<Object> asd = new ArrayList<>();
		double gujingT =0;
		double hanxianT =0;
		double dianjiaoT =0;
		double waiguanT =0;
		double fenguangT =0;
		double zhuangdaiT =0;
		double muzaoT =0;
		double qiegeT =0;
		for (int i = 0; i < listDay.size(); i++) {
			double gujing =0;
			double hanxian =0;
			double dianjiao =0;
			double waiguan =0;
			double fenguang =0;
			double zhuangdai =0;
			double muzao =0;
			double qiege =0;
			

			JSONObject  member1=new JSONObject();
			for (int j = 0; j < list.size(); j++) {
				int hello = Integer.parseInt(list.get(j).getCALENDAR_SEQ());
				int nihao = Integer.parseInt(listDay.get(i));
				if(hello == nihao) {
					if("固晶站".equals(list.get(j).getSTATION_DESC())) {
						gujing=list.get(j).getMOVE_OUT_QTY();
						gujingT +=gujing;
					}else if("焊线站".equals(list.get(j).getSTATION_DESC())) {
						hanxian=list.get(j).getMOVE_OUT_QTY();
						hanxianT +=hanxian;
					}else if("点胶站".equals(list.get(j).getSTATION_DESC())) {
						dianjiao=list.get(j).getMOVE_OUT_QTY();
						dianjiaoT +=dianjiao;
					}else if("外观/折弯站".equals(list.get(j).getSTATION_DESC())) {
						waiguan=list.get(j).getMOVE_OUT_QTY();
						waiguanT +=waiguan;
					}else if("装带/注塑站".equals(list.get(j).getSTATION_DESC())) {
						zhuangdai=list.get(j).getMOVE_OUT_QTY();
						zhuangdaiT +=zhuangdai;
					}else if("分光站".equals(list.get(j).getSTATION_DESC())) {
						fenguang=list.get(j).getMOVE_OUT_QTY();
						fenguangT +=fenguang;
					}else if("模造".equals(list.get(j).getSTATION_DESC())) {
						muzao=list.get(j).getMOVE_OUT_QTY();
						muzaoT +=muzao;
					}else if("切割/全检站".equals(list.get(j).getSTATION_DESC())) {
						qiege=list.get(j).getMOVE_OUT_QTY();
						qiegeT +=qiege;
					}
				}				
/*				JSONObject  member1=new JSONObject();
				member1.put("departMent", "SZ2");*/
				
				
			}
			String date1 = listDay.get(i).substring(4, 6)+"/"+listDay.get(i).substring(6, 8);
			member1.put("date", date1);
			member1.put("gujing", Math.round(gujing/3));
			member1.put("hanxian",Math.round(hanxian));
			member1.put("dianjiao", Math.round(dianjiao));
			member1.put("waiguan", Math.round(waiguan));
			member1.put("zhuangdai", Math.round(zhuangdai));
			member1.put("fenguang", Math.round(fenguang));
			member1.put("muzao", Math.round(muzao));
			member1.put("qiege", Math.round(qiege));
			asd.add(member1);
			if(i==listDay.size()-1) {
				JSONObject  memberT=new JSONObject();
				memberT.put("date", "总计");
				memberT.put("gujing", Math.round(gujingT/3));
				memberT.put("hanxian",Math.round(hanxianT));
				memberT.put("dianjiao", Math.round(dianjiaoT));
				memberT.put("waiguan", Math.round(waiguanT));
				memberT.put("zhuangdai", Math.round(zhuangdaiT));
				memberT.put("fenguang", Math.round(fenguangT));
				memberT.put("muzao", Math.round(muzaoT));
				memberT.put("qiege", Math.round(qiegeT));
				asd.add(memberT);
			}
		}
		System.out.println(asd);
		return asd;
	}
	

	
	@CrossOrigin
	@RequestMapping(value="/jt&startDate={startDate}&endDate={endDate}", method=RequestMethod.GET)
	@ResponseBody
	public List<Object> requestPath(@PathVariable String startDate, @PathVariable String endDate) {
		startDate = startDate.replaceAll("-","");
		endDate = endDate.replaceAll("-","");
		List<Test> list = service.findAll(startDate, endDate);
		double SZ2G = 0;
		double SZ2H = 0;
		double SZ2Z = 0;
		double SZ2D = 0;
		double SZ2W = 0;
		double SZ2F = 0;
		
		double SN1G = 0;
		double SN1H = 0;
		double SN1Z = 0;
		double SN1D = 0;
		double SN1W = 0;
		double SN1F = 0;
		
		double SN2G = 0;
		double SN2H = 0;
		double SN2Z = 0;
		double SN2D = 0;
		double SN2W = 0;
		double SN2F = 0;
		
		double SN3G = 0;
		double SN3H = 0;
		double SN3Z = 0;
		double SN3D = 0;
		double SN3W = 0;
		double SN3F = 0;
		
		double SN4G = 0;
		double SN4H = 0;
		double SN4Z = 0;
		double SN4D = 0;
		double SN4W = 0;
		double SN4F = 0;
		
		double SN5G = 0;
		double SN5H = 0;
		double SN5Z = 0;
		double SN5D = 0;
		double SN5W = 0;
		double SN5F = 0;
		
		double SN6G = 0;
		double SN6H = 0;
		double SN6Z = 0;
		double SN6D = 0;
		double SN6W = 0;
		double SN6F = 0;
		
		double SN8G = 0;
		double SN8H = 0;
		double SN8Z = 0;
		double SN8D = 0;
		double SN8W = 0;
		double SN8F = 0;






		for (int i = 0; i < list.size(); i++) {
		/*	if("深圳封装二部".equals(list.get(i).getDEPARTMENT_ID())) {
				if("固晶站".equals(list.get(i).getSTATION_DESC())) {
					SZ2G += list.get(i).getMOVE_OUT_QTY();
				}else if("焊线站".equals(list.get(i).getSTATION_DESC())) {
					SZ2H += list.get(i).getMOVE_OUT_QTY();
				}else if("点胶站".equals(list.get(i).getSTATION_DESC())) {
					SZ2D += list.get(i).getMOVE_OUT_QTY();
				}else if("外观/折弯站".equals(list.get(i).getSTATION_DESC())) {
					SZ2W += list.get(i).getMOVE_OUT_QTY();
				}else if("装带/注塑站".equals(list.get(i).getSTATION_DESC())) {
					SZ2Z += list.get(i).getMOVE_OUT_QTY();
				}else if("分光站".equals(list.get(i).getSTATION_DESC())) {
					SZ2F += list.get(i).getMOVE_OUT_QTY();
				}
			}else*/ if("苏州封装一部".equals(list.get(i).getDEPARTMENT_ID())) {
				if("固晶站".equals(list.get(i).getSTATION_DESC())) {
					SN1G += list.get(i).getMOVE_OUT_QTY();
				}else if("焊线站".equals(list.get(i).getSTATION_DESC())) {
					SN1H += list.get(i).getMOVE_OUT_QTY();
				}else if("点胶站".equals(list.get(i).getSTATION_DESC())) {
					SN1D += list.get(i).getMOVE_OUT_QTY();
				}else if("外观/折弯站".equals(list.get(i).getSTATION_DESC())) {
					SN1W += list.get(i).getMOVE_OUT_QTY();
				}else if("装带/注塑站".equals(list.get(i).getSTATION_DESC())) {
					SN1Z += list.get(i).getMOVE_OUT_QTY();
				}else if("分光站".equals(list.get(i).getSTATION_DESC())) {
					SN1F += list.get(i).getMOVE_OUT_QTY();
				}
			}else if("苏州封装二部".equals(list.get(i).getDEPARTMENT_ID())) {
				if("固晶站".equals(list.get(i).getSTATION_DESC())) {
					SN2G += list.get(i).getMOVE_OUT_QTY();
				}else if("焊线站".equals(list.get(i).getSTATION_DESC())) {
					SN2H += list.get(i).getMOVE_OUT_QTY();
				}else if("点胶站".equals(list.get(i).getSTATION_DESC())) {
					SN2D += list.get(i).getMOVE_OUT_QTY();
				}else if("外观/折弯站".equals(list.get(i).getSTATION_DESC())) {
					SN2W += list.get(i).getMOVE_OUT_QTY();
				}else if("装带/注塑站".equals(list.get(i).getSTATION_DESC())) {
					SN2Z += list.get(i).getMOVE_OUT_QTY();
				}else if("分光站".equals(list.get(i).getSTATION_DESC())) {
					SN2F += list.get(i).getMOVE_OUT_QTY();
				}
			}else if("苏州封装三部".equals(list.get(i).getDEPARTMENT_ID())) {
				if("固晶站".equals(list.get(i).getSTATION_DESC())) {
					SN3G += list.get(i).getMOVE_OUT_QTY();
				}else if("焊线站".equals(list.get(i).getSTATION_DESC())) {
					SN3H += list.get(i).getMOVE_OUT_QTY();
				}else if("点胶站".equals(list.get(i).getSTATION_DESC())) {
					SN3D += list.get(i).getMOVE_OUT_QTY();
				}else if("外观/折弯站".equals(list.get(i).getSTATION_DESC())) {
					SN3W += list.get(i).getMOVE_OUT_QTY();
				}else if("装带/注塑站".equals(list.get(i).getSTATION_DESC())) {
					SN3Z += list.get(i).getMOVE_OUT_QTY();
				}else if("分光站".equals(list.get(i).getSTATION_DESC())) {
					SN3F += list.get(i).getMOVE_OUT_QTY();
				}
			}else if("苏州封装四部".equals(list.get(i).getDEPARTMENT_ID())) {
				if("固晶站".equals(list.get(i).getSTATION_DESC())) {
					SN4G += list.get(i).getMOVE_OUT_QTY();
				}else if("焊线站".equals(list.get(i).getSTATION_DESC())) {
					SN4H += list.get(i).getMOVE_OUT_QTY();
				}else if("点胶站".equals(list.get(i).getSTATION_DESC())) {
					SN4D += list.get(i).getMOVE_OUT_QTY();
				}else if("外观/折弯站".equals(list.get(i).getSTATION_DESC())) {
					SN4W += list.get(i).getMOVE_OUT_QTY();
				}else if("装带/注塑站".equals(list.get(i).getSTATION_DESC())) {
					SN4Z += list.get(i).getMOVE_OUT_QTY();
				}else if("分光站".equals(list.get(i).getSTATION_DESC())) {
					SN4F += list.get(i).getMOVE_OUT_QTY();
				}
			}else if("苏州封装五部".equals(list.get(i).getDEPARTMENT_ID())) {
				if("固晶站".equals(list.get(i).getSTATION_DESC())) {
					SN5G += list.get(i).getMOVE_OUT_QTY();
				}else if("焊线站".equals(list.get(i).getSTATION_DESC())) {
					SN5H += list.get(i).getMOVE_OUT_QTY();
				}else if("点胶站".equals(list.get(i).getSTATION_DESC())) {
					SN5D += list.get(i).getMOVE_OUT_QTY();
				}else if("外观/折弯站".equals(list.get(i).getSTATION_DESC())) {
					SN5W += list.get(i).getMOVE_OUT_QTY();
				}else if("装带/注塑站".equals(list.get(i).getSTATION_DESC())) {
					SN5Z += list.get(i).getMOVE_OUT_QTY();
				}else if("分光站".equals(list.get(i).getSTATION_DESC())) {
					SN5F += list.get(i).getMOVE_OUT_QTY();
				}
			}else if("苏州封装六部".equals(list.get(i).getDEPARTMENT_ID())) {
				if("固晶站".equals(list.get(i).getSTATION_DESC())) {
					SN6G += list.get(i).getMOVE_OUT_QTY();
				}else if("焊线站".equals(list.get(i).getSTATION_DESC())) {
					SN6H += list.get(i).getMOVE_OUT_QTY();
				}else if("点胶站".equals(list.get(i).getSTATION_DESC())) {
					SN6D += list.get(i).getMOVE_OUT_QTY();
				}else if("外观/折弯站".equals(list.get(i).getSTATION_DESC())) {
					SN6W += list.get(i).getMOVE_OUT_QTY();
				}else if("装带/注塑站".equals(list.get(i).getSTATION_DESC())) {
					SN6Z += list.get(i).getMOVE_OUT_QTY();
				}else if("分光站".equals(list.get(i).getSTATION_DESC())) {
					SN6F += list.get(i).getMOVE_OUT_QTY();
				}
			}else if("苏州封装八部".equals(list.get(i).getDEPARTMENT_ID())) {
				if("固晶站".equals(list.get(i).getSTATION_DESC())) {
					SN8G += list.get(i).getMOVE_OUT_QTY();
				}else if("焊线站".equals(list.get(i).getSTATION_DESC())) {
					SN8H += list.get(i).getMOVE_OUT_QTY();
				}else if("点胶站".equals(list.get(i).getSTATION_DESC())) {
					SN8D += list.get(i).getMOVE_OUT_QTY();
				}else if("外观/折弯站".equals(list.get(i).getSTATION_DESC())) {
					SN8W += list.get(i).getMOVE_OUT_QTY();
				}else if("装带/注塑站".equals(list.get(i).getSTATION_DESC())) {
					SN8Z += list.get(i).getMOVE_OUT_QTY();
				}else if("分光站".equals(list.get(i).getSTATION_DESC())) {
					SN8F += list.get(i).getMOVE_OUT_QTY();
				}
			}
			
		}
		List<Object> asd = new ArrayList<>();
/*		JSONObject  member1=new JSONObject();
		member1.put("departMent", "SZ2");
		member1.put("gujing", Math.round(SZ2G/3));
		member1.put("hanxian", Math.round(SZ2H));
		member1.put("dianjiao", Math.round(SZ2D));
		member1.put("waiguan", Math.round(SZ2W));
		member1.put("zhuangdai", Math.round(SZ2Z));
		member1.put("fenguang", Math.round(SZ2F));*/
		
		JSONObject  member2=new JSONObject();
		member2.put("departMent", "SN1");
		member2.put("gujing", Math.round(SN1G/3));
		member2.put("hanxian", Math.round(SN1H));
		member2.put("dianjiao", Math.round(SN1D));
		member2.put("waiguan", Math.round(SN1W));
		member2.put("zhuangdai", Math.round(SN1Z));
		member2.put("fenguang", Math.round(SN1F));
		
		JSONObject  member3=new JSONObject();
		member3.put("departMent", "SN2");
		member3.put("gujing", Math.round(SN2G/3));
		member3.put("hanxian", Math.round(SN2H));
		member3.put("dianjiao", Math.round(SN2D));
		member3.put("waiguan", Math.round(SN2W));
		member3.put("zhuangdai", Math.round(SN2Z));
		member3.put("fenguang", Math.round(SN2F));
		
		JSONObject  member4=new JSONObject();
		member4.put("departMent", "SN3");
		member4.put("gujing", Math.round(SN3G/3));
		member4.put("hanxian", Math.round(SN3H));
		member4.put("dianjiao", Math.round(SN3D));
		member4.put("waiguan", Math.round(SN3W));
		member4.put("zhuangdai", Math.round(SN3Z));
		member4.put("fenguang", Math.round(SN3F));
		
		JSONObject  member5=new JSONObject();
		member5.put("departMent", "SN4");
		member5.put("gujing", Math.round(SN4G/3));
		member5.put("hanxian", Math.round(SN4H));
		member5.put("dianjiao", Math.round(SN4D));
		member5.put("waiguan", Math.round(SN4W));
		member5.put("zhuangdai",Math.round(SN4Z) );
		member5.put("fenguang", Math.round(SN4F));
		
		JSONObject  member6=new JSONObject();
		member6.put("departMent", "SN5");
		member6.put("gujing", Math.round(SN5G/3));
		member6.put("hanxian", Math.round(SN5H));
		member6.put("dianjiao", Math.round(SN5D));
		member6.put("waiguan", Math.round(SN5W));
		member6.put("zhuangdai", Math.round(SN5Z));
		member6.put("fenguang", Math.round(SN5F));

		JSONObject  member7=new JSONObject();
		member7.put("departMent", "SN6");
		member7.put("gujing", Math.round(SN6G/3));
		member7.put("hanxian", Math.round(SN6H));
		member7.put("dianjiao", Math.round(SN6D));
		member7.put("waiguan", Math.round(SN6W));
		member7.put("zhuangdai", Math.round(SN6Z));
		member7.put("fenguang", Math.round(SN6F));
		
		/*		JSONObject  member8=new JSONObject();
		member8.put("departMent", "SN8");
		member8.put("gujing", Math.round(SN8G/3));
		member8.put("hanxian", Math.round(SN8H));
		member8.put("dianjiao",Math.round(SN8D) );
		member8.put("waiguan", Math.round(SN8W));
		member8.put("zhuangdai", Math.round(SN8Z));
		member8.put("fenguang", Math.round(SN8F));*/
		
/*		asd.add(member1);*/
		asd.add(member2);
		asd.add(member3);
		asd.add(member4);
		asd.add(member5);
		asd.add(member6);
		asd.add(member7);
/*		asd.add(member8);*/
	    return asd;

	}
}
