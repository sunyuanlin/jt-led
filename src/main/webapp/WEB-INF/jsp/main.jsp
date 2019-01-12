<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html><head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"> 
<title>版本追溯</title> 
<meta name="keywords" content="产品"> 
<meta name="description" content="专注LED封装"> 
<link rel="Bookmark" href="favicon.ico"> 
<link rel="Shortcut Icon" href="img/5861eaecbdc70.png"> 

<link href="../css/H-ui.doc.css" rel="stylesheet" type="text/css">
<link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css">
<link href="../css/iconfont.css" rel="stylesheet" type="text/css">
<link href="../css/H-ui.min.css" rel="stylesheet" type="text/css">

</head>
<style>
	.docs-preview {
    position: relative;
    margin: 15px 30%;  
    padding: 39px 19px 14px;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 4px
	}

.docs-preview:after {
    content: "历史版本";
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
.icon_lists .Hui-iconfont {
	font-size: 25px;
	line-height: 100px;
	margin: 10px 0;
	color: #333;
	-webkit-transition: font-size 0.25s ease-out 0s;
	-moz-transition: font-size 0.25s ease-out 0s;
	transition: font-size 0.25s ease-out 0s;
}
.aaaa{
font-size: 25px;
cursor:pointer;
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
                        <li>
                            <a href="/SSM/price/upload">文件上传</a>
                        </li>
                        <li class="current">
                            <a href="/SSM/price/list">单价版本</a>
                        </li>
                    </ul>
			</nav>
		</div>
	</div>
</header>

<div class="codeView docs-preview">
<table class="table table-border">
            <thead>
              <tr>
                <th>序号</th>
                <th>版本</th>
                <th>创建时间</th>
                <th style="width:15%">下载</th>
              </tr>
            </thead>
            <tbody id="trtr">
             
            </tbody>
          </table>

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
<script>
function getAjaxData() {
    $.ajax({
        url: 'http://192.168.1.116:8081/SSM/price/list/version',
        type: 'get',
        dataType: 'json',
        success: function (data) {
        	var html ;
             for (var i=0;i<data.length;i++){
            	 var a = i+1;
                 html += "<tr><td>"+a+"</td><td>"+data[i].version+"</td><td>"+data[i].c_TIME+"</td><td ><i class='icon Hui-iconfont aaaa' onclick='download(\""+data[i].address+"\")'></i></td></tr>";
         }
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

function download(address) {
	
	window.location.href="http://192.168.1.116:8081/SSM/file/download?filename="+address;
/* 	$.ajax({
        url: 'http://127.0.0.1:8081/SSM/file/download?filename='+address+'',
        type: 'get',
        dataType: 'json',
        success: function (data) {
        }
    }); */

}

</script>


</body></html>