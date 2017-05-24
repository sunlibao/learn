<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<jsp:include page="./include/head.jsp"></jsp:include>

<div id="main"  style="width:1202px;height: 300px;display: block; border: 1px solid;">
		<div class="leftMenu">
			<jsp:include page="./include/left.jsp"></jsp:include>
		</div>
		<div class="content" >
				<div style="height: 45px;line-height: 45px;padding-top: 15px;text-align: right;">
					 <button type="button" onclick="toAddShares()" class="btn btn-primary btn-sm">添加系统股票</button>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>id</th>
							<th>股票编号</th>
							<th>股票名称</th>
							<th>股票简介</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sharesList}" var="share">
							<tr>
								<td>${share.id}</td>
								<td>${share.code}</td>
								<td>${share.name}</td>
								<td>${share.note}</td>
								<td>
									 <button type="button" onclick="deleteShares(${share.id})" class="btn btn-primary btn-sm">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
</div>

<jsp:include page="./include/foot.jsp"></jsp:include>

<script type="text/javascript">
	
	/** 
	* 跳转添加页面
	*/
	function toAddShares(){
		window.location="${ctx}/shares/toAddShares";
	}
	
	/** 
	* 跳转添加页面
	*/
	function deleteShares(sharesId){
		
		layer.confirm("您确定要删除么?",function(){
			window.location="${ctx}/shares/deleteShares?sharesId="+sharesId;
		})
		
		
	}
	
	


</script>
</body>
</html>