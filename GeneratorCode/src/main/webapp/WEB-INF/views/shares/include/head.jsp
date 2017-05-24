<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>  

<link rel="stylesheet"  href="${ctx}/css/shares/common.css"></link>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${ctx}/static/lib/layer/layer.js"></script>
<script src="${ctx}/static/lib/My97DatePicker/WdatePicker.js"></script>


<div id="header">
	欢迎进入股票管理页面
</div>