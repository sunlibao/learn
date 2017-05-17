<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/static/lib/jquery-3.2.0.js"></script>
<script type="text/javascript" src="${ctx}/static/lib/layer/layer.js"></script>
<title>爱学习</title>
<style type="text/css">

body{
	margin:  0 auto;
	padding: 0  auto;
}

ul{
	list-style-type: none;
}

li{
	float: left;
	word-spacing: 30px;
	margin-left: 30px;
}



.header{
	padding-bottom:30px;
	background-color: gray;
	color: white;
}

.header img{
	margin-left: 30px;
}

.header span{
	margin-right: 30px;
	margin-top: 30px;
	float: right;
	cursor: pointer;
}

.header span a{
	text-decoration: none;
	color: white;
}



.banner{
}

.banner img{
	margin:  0 auto;
}


#content{
	clear: both;
	margin-bottom: 30px;
	min-height: 400px;
	
}



.box{
	width: 280px;
	border:  1px solid;
	margin-top: 30px;
	
}

.box h4{
	height:34px;
	background-color: yellow;
	line-height: 34px;
	padding-left:15px;
}

.box span{
	height:31px;
	line-height:31px;
	font-size: 13px;
	padding-left: 30px;
}

.box div label{
	height:24px;
	line-height:24px;
	width:300px;
	display:block;
	padding-left: 20px;
	word-spacing: normal;
	white-space: nowrap;
}

.box div span{
	font-size: 13px;
}


#footer_space{
	clear: both;
	height: 20px;
	
}

.footer{
	clear: both;
	background-color:black;
	height:45px;
	line-height:45px;
	padding-left: 36px;
	
}

.footer  span{
	background-color: black;
	color: white;
	float: left;
	font-size: 13px;
	margin-left: 37px;
}

.footer div{
	clear: both;
	background-color: black;
}

.footer p{
	color: white;
}

</style>


</head>
<body>
	<div class="header">
		<img src="${ctx}/image/font/logo.png"></img>
		<c:if test="${LoginCustomer == null}">
			<span><a id="loginButton">登录</a></span>
			<span><a>注册</a></span>
		</c:if>
		<c:if test="${LoginCustomer != null}">
			<span><a href="javascript:void(0);" id="loginOutButton" >注销</a></span>
			<span>欢迎     ${LoginCustomer.userName}  !!!</span>
			<span><a href="${ctx}/shares/sharesIndex"  >股票管理</a></span>
		</c:if>
	</div>
	
	<div id="content">
		<div>
			<h3>推荐课程</h3>
			<ul>
				<li>
					<div class="box">
						<h4>推荐课程</h4>
						<div>
							<label>HTMl学习</label>
							<span>基础的知识讲解，试用于基础的数据建设。</span>
						</div>
						<span>初级</span>
						<span>1420人</span>
					</div>
					
				</li>
				<li>
					<div class="box">
						<h4>推荐课程</h4>
						<div>
							<label>HTMl学习</label>
							<span>基础的知识讲解，试用于基础的数据建设。</span>
						</div>
						<span>初级</span>
						<span>1420人</span>
					</div>
					
				</li>
				<li>
					<div class="box">
						<h4>推荐课程</h4>
						<div>
							<label>HTMl学习</label>
							<span>基础的知识讲解，试用于基础的数据建设。</span>
						</div>
						<span>初级</span>
						<span>1420人</span>
					</div>
					
				</li>
				<li>
					<div class="box">
						<h4>推荐课程</h4>
						<div>
							<label>HTMl学习</label>
							<span>基础的知识讲解，试用于基础的数据建设。</span>
						</div>
						<span>初级</span>
						<span>1420人</span>
					</div>
					
				</li>
			</ul>
		</div>
	</div>
	<div id="footer_space"></div>
	<div class="footer">
			<span><a>首页</a></span>
			<span><a>企业合作</a></span>
			<span><a>联系我们</a></span>
			<span><a>常见问题</a></span>
			<span><a>意见反馈</a></span>
		<div></div>
			<p>文网文</p>
	</div>
	
	
	
	
	
	<script type="text/javascript">
	
	/*
		点击登录，弹出登录窗口
	*/
	$("#loginButton").on("click",function(){
		window.location.href="${ctx}/front/login";
	});
	
	//退出登录
	$("#loginOutButton").on("click",function(){
		window.location.href="${ctx}/front/loginOut";
	})
	
	$("#registerButton").on("click",function(){
		window.location.href="${ctx}/front/toRegister";
	})
	
	
	</script>
	
	
</body>
</html>