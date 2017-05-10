<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
#loginBox{
	width: 300px;
	margin: 0 auto ;
	padding-top: 40px;
}

.title{
	font-size: 13px;
	height: 35px;
	line-height: 35px;
	background-color: black;
	color: white;
	padding-left: 35px;
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
			<form action="front/login" method="post">
				<div>
					<input name="userName"></input>
					<span id="userNameError"></span>
				</div>
				<div>
					<input name="password"></input>
					<span id="passwordError"></span>
				</div>
				<div>
					<button>登录</button>
				</div>
			</form>
		</div>
	</div>
		
</body>
</html>