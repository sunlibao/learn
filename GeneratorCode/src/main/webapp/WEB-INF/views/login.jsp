<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代码工具</title>
<script type="text/javascript">
	window.$ctx = "${ctx}";
</script>
<script type='text/javascript' src='${ctx}/static/lib/require/require.js'></script>
<script type='text/javascript' src='${ctx}/static/lib/require/config.js'></script>
<script type='text/javascript' src='${ctx}/static/lib/director/director.js'></script>
<style type="text/css">

/*兼容谷歌浏览器*/
input:-webkit-autofill {
    -webkit-box-shadow: 0 0 0px 1000px white inset !important;
}

.main{
	margin: 0px;
	padding: 0px;
	height:300px;
}

.adv{
	margin:0px;
	padding:0px;
	width: 724px;
	height:320px;
	float: left;
	background-image: url(${ctx}/image/back.jpg);
}



.login{
	margin:0px;
	padding:0px;
	width: 280px;
	height:320px;
	float: right;
	border-color: gray;
	border-width: 1px;
	border-style: inset;

}

.login div{
	display: block;
	width: 200px;
	float: left;
	margin-top: 20px;
}

.login div span{
	padding:0px;
	border:0px;
	display:block;
	text-align:left;
	background-color: white;
	line-height: 25px;
	float: left;
	width: 75px;
	font-family: fantasy;
	margin-left: 25px;
	
}


.login div input{
	width: 220px;
	height: 20px;
	line-height: 20px;
	text-align: center;
	margin-left:20px;
	float: left;
	background: transparent;
}



.login div button{
	margin-top: 20px auto 0 auto ;
	width: 120px;
	height: 33px;
	
}



.login div label{
	margin:0px;
	padding:0px;
	border:0px;
	width:210px;
	text-align:center;
	background-color: white;
}


</style>
</head>
<body>

<div style="width: 1024px;margin: 0 auto;text-align: center;">
	<h1>代码生成</h1>
</div>
<div class="main">
	<div style="width: 1024px;margin: 0 auto;text-align: center;">
		<div class="adv">
			
		</div>
		<div class="login">
			<form action="j_spring_security_check" method="post">
				<div>
					<span>用户名:</span>
					<label> <input name="j_username" type="text"  /> </label>
				</div>
				<div>
					<span>密码:</span>
					<label> <input name="j_password" type="password"/> </label>
				</div>
				<div class="button">
					<button id="login" type="submit">登录</button>
				</div>
				<div>
					<p style="color: red;">${errorMsg}</p>
				</div>
		</form>
		</div>
	</div>

</div>

<div class="footer">

</div>

</body>
</html>