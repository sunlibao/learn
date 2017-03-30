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

</head>
<body>

<div>
	<form action="${ctx}/login/login.do" method="post">
		<div>
			<span>用户名</span>
			<span> <input name="username" type="text"  /> </span>
		</div>
		<div>
			<span>密码</span>
			<span> <input name="password" type="password"/> </span>
		</div>
		<div>
			<button id="login" type="submit">登录</button>
		</div>
		<div>
			<span style="color: red;">${errorMsg}</span>
		</div>
</form>


</div>

</body>
</html>