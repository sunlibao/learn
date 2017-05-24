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
				<div>
					<span>股票名称：${sharesVO.name}</span><span>股票编号：${sharesVO.code}</span>
				</div>
				<div style="height: 45px;line-height: 45px;padding-top: 15px;text-align: right;">
					 <button type="button" onclick="toAddSharesOption(${userSharesId})" class="btn btn-primary btn-sm">添加记录</button>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>操作id</th>
							<th>价格</th>
							<th>操作</th>
							<th>操作时间</th>
							<th>操作说明</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userSharesOptionList}" var="userShareOption">
							<tr>
								<td>${userShareOption.id}</td>
								<td>${userShareOption.price}</td>
								<td>
								<c:if test="${userShareOption.dealOption == 1}">
									<span style="color: red;">买入</span>
								</c:if>
								<c:if test="${userShareOption.dealOption == 2}">
									<span style="color:green;">卖出</span>
								</c:if>
								</td>
								<td><fmt:formatDate value="${userShareOption.dealOptionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  </td>
								<td>${userShareOption.note}</td>
								<td>
									<button type="button" onclick="deleteUserSharesOption(${userShareOption.id})" class="btn btn-primary btn-sm">删除</button>
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
	function toAddSharesOption(userSharedId){
		window.location="${ctx}/shares/toAddSharesOption?userSharesId="+userSharedId;
	}
	
	/** 
	* 跳转添加页面
	*/
	function deleteUserSharesOption(id){
		
		layer.confirm("您确定要删除么?",function(){
			window.location="${ctx}/shares/deleteUserSharesOption?id="+id+"&userSharesId="+${userSharesId}+"&shareId="+${shareId};
		})
		
		
	}
	


</script>

</body>
</html>