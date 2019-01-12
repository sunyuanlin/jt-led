<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html><head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"> 
<title>文件上传</title> 
<meta name="keywords" content="产品"> 
<meta name="description" content="专注LED封装"> 
<link rel="Bookmark" href="favicon.ico"> 
<link rel="Shortcut Icon" href="img/5861eaecbdc70.png"> 
<link rel="stylesheet" type="text/css" href="https://lib.h-ui.net/Hui-iconfont/1.0.9/iconfont.min.css">
<link href="../css/H-ui.doc.css" rel="stylesheet" type="text/css">
<link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css">
<link href="../css/iconfont.css" rel="stylesheet" type="text/css">
<link href="../css/H-ui.min.css" rel="stylesheet" type="text/css">

</head> 
<style>
	.docs-upload {
    position: relative;
    margin: 15px 25%;
    
    padding: 39px 19px 14px;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 4px
	}

.docs-upload:after {
    content: "Excel上传";
    position: absolute;
    top: -1px;
    left: -1px;

    padding: 3px 7px;
    font-size: 12px;
    font-weight: bold;
    background-color: #f5f5f5;
    border: 1px solid #ddd;
    color: #9da0a4;
    border-radius: 4px 0 4px 0;
}

	.docs-preview {
    position: relative;
    margin: 15px 25%;  
    padding: 39px 19px 14px;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 4px
	}

.docs-preview:after {
    content: "文件预览";
    position: absolute;
    top: -1px;
    left: -1px;
    padding: 3px 7px;
    font-size: 12px;
    font-weight: bold;
    background-color: #f5f5f5;
    border: 1px solid #ddd;
    color: #9da0a4;
    border-radius: 4px 0 4px 0;
}
.content{
	padding-bottom:20px;
}


</style>
<body>
<div>
<header class="navbar-wrapper">
	<div class="navbar navbar-black navbar-fixed-top">
		<div class="container-fluid cl" style='padding-left:110px'> 
	<a class="logo navbar-logo" href="http://www.jt-led.com/">Kinglight</a> 
		<span class="logo navbar-slogan hidden-xs">晶台光电</span>
		 <span class="logo navbar-slogan hidden-xs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
<!-- 		 <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;"></a> -->
			<nav id="Hui-nav" class="nav navbar-nav">
				                    <ul class="cl">
                        <li>
                            <a href="/SSM">产品单价</a>
                        </li>
                        <li class="current">
                            <a href="/SSM/price/upload">文件上传</a>
                        </li>
                        <li>
                            <a href="/SSM/price/list">单价版本</a>
                        </li>
                    </ul>
			</nav>
		</div>
	</div>
</header>

<div class="codeView docs-upload">
<!-- 				<p>Excel上传</p>
				<span class="btn-upload">
  <a href="javascript:void();" class="btn btn-primary radius btn-upload"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
  <input type="file" multiple name="file_0" class="input-file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" id="upload_excel"/>
</span>
<div style="margin-top: 13px;">
<input class="btn btn-primary radius" type="submit" value="上传">
</div> -->
<form action="/SSM/file/fileupload.do" method="post" enctype="multipart/form-data" onsubmit="return check();">
        <span class="btn-upload">
        
  <a href="javascript:void();" class="btn btn-primary radius btn-upload"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
  <input type="file" multiple name="file" class="input-file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" id="upload_excel"/>
</span>
<div style="margin-top: 13px;">
<input class="btn btn-primary radius" type="submit" value="上传">
</div>

<div style="margin-top: 13px;">
<input class="btn btn-primary radius" type="button" onclick="download()" value="模板下载">
</div>


<!-- <div style="margin-top: 13px;">
<input class="btn btn-primary radius" type="button" onclick="DuplicateChecking()" value="查重">
</div> -->
        
    </form>



				</div>


</div>

<div class="codeView docs-preview">
				<div class='content' id="content1" style='text-align:center;font-size: 15px;'>还未选择任何.xlsx文件</div>
				<div class='content' id="content"></div>
				</div>


</div>


          <footer class="footer mt-20 hidden-xs">
    <div class="container-fluid">
        <nav> <a href="http://www.jt-led.com/" target="_blank">关于我们</a> <span class="pipe">|</span> <a href="http://www.jt-led.com/list-125.html" target="_blank">联系我们</a> <span class="pipe">|</span> <a href="/SSM/price/notfound">法律声明</a> </nav>
        <p>Copyright ©2019 JT-LED All Rights Reserved. <br>
        </p>
    </div> 
</footer>
<script type="text/javascript" src="../js/jquery.min.js"></script> 
<!-- <script type="text/javascript" src="js/H-ui.js"></script> --> 
<script type="text/javascript" src="../js/H-ui.min.js"></script>
<script type="text/javascript" src="../js/xlsx.core.min.js"></script>
<script>
function download(){
	window.location.href="http://192.168.1.116:8081/SSM/file/download?filename=单价模板.xlsx";
}

/* function DuplicateChecking() {
	var excel_file = $("#upload_excel").val();
	if (excel_file == "" || excel_file.length == 0) {
		alert("请先选中文件");
		return false;
	} else {
		var tr =$('#abc').find('tr');
		var len= tr.length;
 		for (var i = 3; i < len; i++) {			
			var Text1 = $(tr[i]).find('td').eq(0).text();
			var Text2 = $(tr[i]).find('td').eq(1).text();
			var Text3 = $(tr[i]).find('td').eq(2).text();
			console.log(i-2+":"+Text1+"——"+Text2+"——"+Text3)
			for (var j = i+1; j < len; j++) {
				var Text4 = $(tr[j]).find('td').eq(0).text();
				var Text5 = $(tr[j]).find('td').eq(1).text();
				var Text6 = $(tr[j]).find('td').eq(2).text();
				if(Text1==Text4&&Text2==Text5&&Text3==Text6){
					var q = i+2;
					var w = j+2;
					alert("第"+q+"行和第"+w+"行重复了")
				}
			}
		} 
        return true;
    }
	
} */
function check() {
	var excel_file = $("#upload_excel").val();
	if (excel_file == "" || excel_file.length == 0) {
		alert("请选择文件路径！");
		return false;
	} else {
		var tr =$('#abc').find('tr');
		var len= tr.length;
		var count = 0;
		var e = 0;
 		for (var i = 3; i < len; i++) {			
			var Text1 = $(tr[i]).find('td').eq(0).text();
			var Text2 = $(tr[i]).find('td').eq(1).text();
			var Text3 = $(tr[i]).find('td').eq(2).text();
/* 			console.log(i-2+":"+Text1+"——"+Text2+"——"+Text3) */
			for (var j = i+1; j < len; j++) {
				var Text4 = $(tr[j]).find('td').eq(0).text();
				var Text5 = $(tr[j]).find('td').eq(1).text();
				var Text6 = $(tr[j]).find('td').eq(2).text();
				if(Text1==Text4&&Text2==Text5&&Text3==Text6){
					var q = i+2;
					var w = j+2;
					e++;
					console.log("序号："+e+"——第"+q+"行和第"+w+"行重复了");
					
					++count;
				}
			}
		} 
 		if(count>0){
 			alert("上传失败：中间有重复，具体重复请看console")
 			return false;
 		}else{
 			alert("上传成功")
 			return true
 		}
/*         return true; */
    }
}

/* $("#excel_button").on('click', function() {  
    var excel_file = $("#upload_excel").val();  
    if (excel_file == "" || excel_file.length == 0) {  
        alert("请选择文件路径！");  
        return false;  
    } else {  
        return true;  
    }   
}); */
    function handleFile(e) {
        var files = e.target.files;
        var i,f;
        for (i = 0, f = files[i]; i != files.length; ++i) {
            var reader = new FileReader();
            var name = f.name;
            reader.onload = function(e) {
                var data = e.target.result;

                var workbook = XLSX.read(data, {type: 'binary'});
                var sheet_name_list = workbook.SheetNames;
                var result = [];
                var headItem=[];
                var dataItem=[];
                var dataFormulae=[];
                var dataCsv=[];
                var headCode=[];
                var rowNum=0;

                sheet_name_list.forEach(function(y) {
                    var worksheet = workbook.Sheets[y];
                    var json = XLSX.utils.sheet_to_json(workbook.Sheets[y]);
                    var formulae = XLSX.utils.sheet_to_formulae(workbook.Sheets[y]);
                    var csv = XLSX.utils.sheet_to_formulae(workbook.Sheets[y]);
                    if(json.length > 0){
                        result=json;
                        dataCsv=csv;
                    }
                });
                /*$.each(dataFormulae,function (j,head) {
                    var headlist=head.split("='")
                    if(/^[A-Z]1$/.test(headlist[0])){
                        headItem.push(headlist[1])
                    }
                })
                $.each(result,function (i,val) {
                    var data=[]
                    $.each(headItem,function (k,head) {
                        val[head]!=undefined?data.push(val[head]):data.push("")
                    })
                    dataItem.push(data)
                })*/
                $.each(dataCsv,function (j,head) {
                    var headlist=head.split("='")
                    rowNum=/^[A-Z]+(\d+)$/.exec(headlist[0])[1];
                    headCode.indexOf(/^([A-Z]+)\d+$/.exec(headlist[0])[1])==-1?headCode.push(/^([A-Z]+)\d+$/.exec(headlist[0])[1]):'';

                })
                headCode=headCode.sort();
                $.each(headCode,function (i,val) {
                    headItem[val]='';
                })
                for(var i=0;i<Number(rowNum)-1;i++){
                    var obj={};
                    $.each(headCode,function (i,val) {
                        obj[val]='';
                    })
                    dataItem[i]=obj;

                }
                $.each(dataCsv,function (j,head) {
                    var headlist=head.split("='")
                    var code= /^([A-Z]+)\d+$/.exec(headlist[0])[1];
                    var row= /^[A-Z]+(\d+)$/.exec(headlist[0])[1];
                    if(row==1){
                        headItem[code]=headlist[1]
                    }else{
                        dataItem[row-2][code]=headlist[1];
                    }

                })
                var headstr='';
                var datastr='';
                $.each(headItem,function (i,head) {
                    headstr=headstr+'<th style="border: 1px solid #cccccc">'+head+'</th>'
                })
                $.each(dataItem,function (i,data) {
                    datastr=datastr+'<tr >';
                    $.each(data,function (j,val) {
                        datastr=datastr+'<td style="border: 1px solid #cccccc">'+val+'</td>'
                    })
                    datastr=datastr+'</tr>';
                })
                var table='<table style="border: 1px solid #cccccc;border-collapse: collapse;"><thead><tr style="font-weight: bold">'+headstr+'</tr></thead><tbody id="abc">'+datastr+ '</tbody></table>'
                $('#content').html('');
                $('#content').html( $('#content').html()+table);

            };
            reader.readAsBinaryString(f);
        }
/*        $('#upload_excel').val('')*/
        $("#content1").hide();
    }
    $('#upload_excel').bind('change', handleFile);
</script>


</body></html>