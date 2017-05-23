<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
	<ul class="list-group">
		<li class="list-group-item"><a href="${ctx}/shares/myShares">我的股票</a></li>
	</ul>
