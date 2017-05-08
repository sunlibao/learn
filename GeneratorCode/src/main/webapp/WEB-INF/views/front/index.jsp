<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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



.banner{
}

.banner img{
	margin:  0 auto;
}




.box{
	width: 320px;
	border:  1px solid;
	
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




</style>


</head>
<body>
	<div class="header">
		<img src="${ctx}/image/font/logo.png"></img>
		<span><a>登录</a></span>
		<span><a>注册</a></span>
	</div>
	
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
	
	
</body>
</html>