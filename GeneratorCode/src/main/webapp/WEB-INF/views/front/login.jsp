<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
#loginBox{
	
	width: 300px;
	margin: 0 auto ;
	margin-top:150px;
	padding-top: 40px;
	border: 1px solid;
	padding: 30px;
	background-color: blue;
}

.title{
	height: 50px;
	line-height: 50px;
	background-color: black;
	color: white;
	text-align: center;
}

.content{
	margin-top: 15px;
}

.content div{
	margin-top: 20px;
}

.input_item{
	height: 30px;
	line-height: 30px;
	width: 300px;
}

.loginButton{
	margin-top:30px;
	margin-left:100px;
	width: 120px;
	height: 40px;
	line-height: 40px;
}

.errorMessage{
	font-size: 13px;
	color: red;
}


.

</style>

</head>
<body>
	<div id="loginBox">
		<div class="title">
			<span>登录</span>
		</div>
		<div class="content">
			<form action="${ctx}/front/login/login" method="post">
				<input type="hidden" name="url" url="${url}"/>
				<div>
					<input name="userName" type="text" class="input_item" ></input>
				</div>
				<div>
					<input name="password" type="password"  class="input_item"></input>
				</div>
				<div class="errorMessage">${errorMessage}</div>
				<button class="loginButton">登录</button>
			</form>
		</div>
	</div>
		
</body>
</html>