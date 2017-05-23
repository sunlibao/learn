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
		<div class="leftMenu">
			<jsp:include page="./include/left.jsp"></jsp:include>
		</div>
		<div  class="content">
				<div style="height: 45px;line-height: 45px;padding-top: 15px;text-align: right;">
					 <button type="button" onclick="toUserShares()" class="btn btn-primary btn-sm">添加股票</button>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>用户id</th>
							<th>股票名称</th>
							<th>股票编号</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sharesList}" var="shareDto">
							<tr>
								<td>${shareDto.userSharesId}</td>
								<td>${shareDto.name}</td>
								<td>${shareDto.code}</td>
								<td><a href="${ctx}/shares/findShareOption?userSharesId=${shareDto.userSharesId}&shareId=${shareDto.shareId}">查看操作记录</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
</div>
<jsp:include page="./include/foot.jsp"></jsp:include>
<script type="text/javascript">
	
	/** 
	* 跳转添加用户股票页面
	*/
	function toAddSharesOption(){
		window.location="${ctx}/shares/toAddUserShares";
	}

</script>
</body>
</html>