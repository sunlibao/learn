<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>股票管理页面</title>
<style type="text/css">
	ul {
	list-style-type: none;
	
}
a{
	text-decoration: none;
}
</style>
</head>
<body>
<jsp:include page="./include/head.jsp"></jsp:include>
<div id="main">
		<jsp:include page="./include/left.jsp"></jsp:include>
		<div id="center">
				欢迎使用
		</div>
</div>
<jsp:include page="./include/foot.jsp"></jsp:include>
</body>
</html>