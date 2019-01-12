package com.yuanjun.control;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.yuanjun.bean.Test1;
import com.yuanjun.bean.Version;
import com.yuanjun.service.PriceService;
import com.yuanjun.service.PriceVersionService;
import com.yuanjun.service.TestService;
import com.yuanjun.service.VersionService;
import com.yuanjun.service.impl.VersionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


@Controller
@RequestMapping("/file")
public class FileUploadUtils {
	@Autowired
	private  VersionService service;
	
	@Autowired
	private  PriceVersionService service1;
	
	@Autowired
	private  PriceService service2;
	
	
	
	static Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)[Ee]{1}[\\+-]?[0-9]*");
    static DecimalFormat ds = new DecimalFormat("0");
    static boolean isENum(String input) {//判断输入字符串是否为科学计数法
        return pattern.matcher(input).matches();
    }
	
	/**
     * 文件下载
     * @throws IOException 
     */
    @RequestMapping(value="/download",method=RequestMethod.GET)
    public void download(@RequestParam(value="filename")String filename,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        //模拟文件，myfile.txt为需要下载的文件  
       String path = "E:\\report\\uploads"+"\\"+filename;  
        //获取输入流  
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close();  
    }
	
	
/*	@CrossOrigin
	@RequestMapping("/readExcelServlet")
	@ResponseBody
	public void readExcelServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
		 
	
		//excel文件路径
        String excelPath = "E:\\readExcelMaven\\test.xlsx";

        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            System.out.println(excel.getName());
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                    return;
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                System.out.print(cell.toString());
                            }
                        }
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}


	*/
	
	
    @RequestMapping("/fileupload.do")
    public  String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	String STATION_ID = "";
    	String EQUIPMENTBIGTYPE = ""; 
    	String PRODUCTBIGTYPE = "";
    	Double PRICE = 0.0;
		int TIMES = 1; 
		String CR_UID = "";
		int VERSION_ID = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());
        System.out.println(timeStamep);
        String res = sdf.format(new Date());

        // uploads文件夹位置
/*        String rootPath = request.getSession().getServletContext().getRealPath("uploads/");*/
        String rootPath = "E:\\report\\uploads\\";
        System.out.println(rootPath);
        // 原始名称
        String originalFileName = file.getOriginalFilename();
        // 新文件名
        String newFileName =res + originalFileName.substring(originalFileName.lastIndexOf("."));
  

        // 新文件
        File newFile = new File(rootPath + newFileName);
        String a = rootPath + newFileName;
        // 判断目标文件所在目录是否存在
/*        if( !newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }*/
        // 将内存中的数据写入磁盘
        file.transferTo(newFile);
        // 完整的url
        String fileUrl = "/" + newFileName;

        String b = a.replaceAll("\\\\\\\\","\\\\\\\\\\\\");
        System.out.println("b"+b);
        
        String VERSION = "";
        
       
        try {
            //String encoding = "GBK";
            File excel = new File(b);
            System.out.println(excel.getName());
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                    return null;
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                
                
                //清空单价表
                service2.drop();
                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                    	if(rIndex==1) {
                    		 Cell cell = row.getCell(1);
                    		 VERSION = cell.toString();
                    		 System.out.println("版本："+cell.toString());
                    	     
                    	     List<Version> list =service.MAXID();
                    	     VERSION_ID = list.get(0).getID();
                    	     String VERSION_1= "";
                    	     if (isENum(VERSION)) {
                    	            VERSION_1 = ds.format(Double.parseDouble(VERSION)).trim();
                    	            System.out.println("测试"+VERSION_1);
                    	        }
                    	     service.insertVerion(VERSION_1, newFileName);
                    	     System.out.println(VERSION_ID);
                    	}else if(rIndex==2) {
                    		Cell cell = row.getCell(1);
                   		 	System.out.println("创建人"+cell.toString());
                   		 	CR_UID =cell.toString();
                    	}else if(rIndex>3){
                    		int firstCellIndex = row.getFirstCellNum();
                            int lastCellIndex = row.getLastCellNum();
                            for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
   /*                         	Cell cell = row.getCell(cIndex);
                               if (cell != null) {
                                    System.out.print("a"+cell.toString());
                                }*/
                           	if(cIndex==0) {
                            		Cell cell = row.getCell(cIndex);
                            		System.out.println("工站："+cell.toString());
                            		STATION_ID = cell.toString();
                            	}else if(cIndex==1) {
                            		Cell cell = row.getCell(cIndex);
                            		System.out.println("设备大类："+cell.toString());
                            		EQUIPMENTBIGTYPE=cell.toString();
                            	}
                            	else if(cIndex==2) {
                            		Cell cell = row.getCell(cIndex);
                            		System.out.println("产品大类："+cell.toString());
                            		PRODUCTBIGTYPE= cell.toString();
                            	}
                            	else if(cIndex==3) {
                            		Cell cell = row.getCell(cIndex);
                            		System.out.println("单价："+cell.toString());
                            		PRICE= Double.parseDouble(cell.toString());
      /*                      		PRICE= cell.toString();*/
                            	}
                            }
                            System.out.println("---------------------");
                            System.out.println(STATION_ID);
                            System.out.println(EQUIPMENTBIGTYPE);
                            System.out.println(PRODUCTBIGTYPE);
                            System.out.println(PRICE);
                            System.out.println(1);
                            System.out.println(CR_UID);
                            System.out.println(VERSION_ID);
                            System.out.println("---------------------");
                            service1.insertPriceVersion(STATION_ID, EQUIPMENTBIGTYPE, PRODUCTBIGTYPE,PRICE, 1, CR_UID, VERSION_ID);
                            service2.insertPrice(STATION_ID, EQUIPMENTBIGTYPE, PRODUCTBIGTYPE, PRICE, TIMES, CR_UID, timeStamep);
                    	}
                    	
                    	
                    	
                        
                    }
                    
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        
        return "redirect:/index.jsp";
    }
/*    public static void main(String[] args) {
    	System.out.println("hello");
    	VersionServiceImpl service = new VersionServiceImpl();
		int a = service.MAXID();
		System.out.println(a);
	}*/
    public static void main(String[] args) { 
/*        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
*/ 

    	MultipartFile file ;
    	HttpServletRequest request;
    	HttpServletResponse response;
    	
        String rootPath = "E:\\report\\uploads\\2.xlsx";
        System.out.println(rootPath);

  
       
        try {
            //String encoding = "GBK";
            File excel = new File(rootPath);
            System.out.println(excel.getName());
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb = null;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum();   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                
                
                //清空单价表
/*                service2.drop();*/
                String html ="";
                String id ="";
                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
             
                    		int firstCellIndex = row.getFirstCellNum();
                            int lastCellIndex = row.getLastCellNum();
                            for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
   /*                         	Cell cell = row.getCell(cIndex);
                               if (cell != null) {
                                    System.out.print("a"+cell.toString());
                                }*/
                           	if(cIndex==0) {
                            		
                            		NumberFormat nf = NumberFormat.getNumberInstance();
                            		Cell cell = row.getCell(cIndex);
                            		cell.setCellType(cell.CELL_TYPE_STRING);
                            		id = cell.toString();
    /*                        		System.out.print(" USERID="+cell.toString()+" or");*/
                            	}else if(cIndex==1) {
                            		
                            		NumberFormat nf1 = NumberFormat.getNumberInstance();
                            		Cell cell = row.getCell(cIndex);
                            		cell.setCellType(cell.CELL_TYPE_STRING);
                            		html = html+"into SYS_K3USERS VALUES('"+cell.toString()+"',"+id+") ";
                            	}
                    	}
                    	
                    	
                    	
                        
                    }
                    
                    
                }
                System.out.println(html);
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    	
    	
    	
    }
}
