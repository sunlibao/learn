<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="./include/head.jsp"></jsp:include>
<div id="main">
		<jsp:include page="./include/left.jsp"></jsp:include>
		<div  style="width: 900px;float:left;margin-left: 30px;">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>用户id</th>
							<th>股票名称</th>
							<th>股票编号</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sharesList}" var="shareDto">
							<tr>
								<td>${shareDto.userSharesId}</td>
								<td>${shareDto.name}</td>
								<td>${shareDto.code}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
</div>
<jsp:include page="./include/foot.jsp"></jsp:include>

</body>
</html>