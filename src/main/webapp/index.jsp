<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html><head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"> 
<title>单价维护</title> 
<meta name="keywords" content="产品"> 
<meta name="description" content="专注LED封装"> 
<link rel="Bookmark" href="favicon.ico"> 
<link rel="Shortcut Icon" href="img/5861eaecbdc70.png"> 

<link href="css/H-ui.doc.css" rel="stylesheet" type="text/css">
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css">
<link href="css/iconfont.css" rel="stylesheet" type="text/css">
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css">
<style>

html {
  height: 100%;
}
body {
  height: 100%
}
.container {
  position: relative;
  min-height: 100%;
}
.content {
  width: 100%;
  height: 100%; /*高度可由内容撑开*/
}
.footer {
  position: relative;
  bottom: 0;
  width: 100%;
}

</style>
</head> 
<body>
<div class="container">
<div class="content">
	<header class="navbar-wrapper">
	<div class="navbar navbar-black navbar-fixed-top">
		<div class="container-fluid cl" style='padding-left:110px'> 
	<a class="logo navbar-logo" href="http://www.jt-led.com/">Kinglight</a> 
		<span class="logo navbar-slogan hidden-xs">晶台光电</span>
		 <span class="logo navbar-slogan hidden-xs">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
<!-- 		 <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;"></a> -->
			<nav id="Hui-nav" class="nav navbar-nav">
				                    <ul class="cl">
                        <li class="current">
                            <a href="/SSM">产品单价</a>
                        </li>
                        <li>
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
<div class="Hui-article" style="position: relative;top:5px;padding-bottom: 50px;">
	<article class="cl" style="margin: 0px 17%;">
		<div class="panel panel panel-primary mt-20">
				<div class="panel-header">计件单价档</div>
				<div class="panel-body">
				
				<table class="table table-border table-bordered table-hover" id="trtr">
          
          </table>
				
				
				</div>
			</div>
	</article>
</div>
</div>



<footer class="footer mt-20 hidden-xs">
    <div class="container-fluid">
        <nav> <a href="http://www.jt-led.com/" target="_blank">关于我们</a> <span class="pipe">|</span> <a href="http://www.jt-led.com/list-125.html" target="_blank">联系我们</a> <span class="pipe">|</span> <a href="/SSM/price/notfound">法律声明</a> </nav>
        <p>Copyright ©2019 JT-LED All Rights Reserved. <br>
        </p>
    </div>
</footer>
</div>




 


<script type="text/javascript" src="js/jquery.min.js"></script> 
<!-- <script type="text/javascript" src="js/H-ui.js"></script> --> 
<script type="text/javascript" src="js/H-ui.min.js"></script>
<script>
function getAjaxData() {
    $.ajax({
        url: 'http://192.168.1.116:8081/SSM/price/list/price',
        type: 'get',
        dataType: 'json',
        success: function (data) {
        	 var html ="<thead><tr><th>序号</th><th>工站</th><th>设备大类</th><th>产品大类</th><th>单价</th><th>创建人</th><th>创建日期</th></tr></thead><tbody>";
             for (var i=0;i<data.length;i++){
                 html += "<tr><td>"+i+"</td><td>"+data[i].STATION_ID+"</td><td>"+data[i].EQUIPMENTBIGTYPE+"</td><td>"+data[i].PRODUCTBIGTYPE+"</td><td>"+data[i].PRICE+"</td><td>"+data[i].CR_UID+"</td><td>"+data[i].CR_DTIME+"</td></tr>";
         }
             html +="</tbody>";
/*              $("#loadingToast").hide();
             $("#startDate").text(startDate);
             $("#endDate").text(endDate); */
             $("#trtr").html(html);
        }
    });

}
$(document).ready(function(){
	getAjaxData();
});

$.Huitotop();
</script>


</body></html>