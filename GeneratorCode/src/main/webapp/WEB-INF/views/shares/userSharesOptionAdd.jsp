<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="./include/head.jsp"></jsp:include>

<div id="main"  style="width:1202px;height: 450px;display: block; border: 1px solid;">
		<div class="leftMenu">
			<jsp:include page="./include/left.jsp"></jsp:include>
		</div>
		<div class="content" >
				<div style="text-align: right;padding-top: 15px;">
					<span>添加记录</span>
				</div>
				<form action="${ctx}/shares/saveUserOption">
					<input type="hidden" name="userSharesId" value="${userSharesId}" >
					<div role="form">
						<div class="form-group">
						    <label for="name">价格</label>
						    <input type="number" class="form-control" name="price" placeholder="请输入价格">
						 </div>	
						 <div class="form-group">
						    <label for="name">选择操作</label>
						    <select class="form-control" name="dealOption">
						        <option>请选择</option>
						        <option value="1">买入</option>
						        <option value="2">卖出</option>
						    </select>
						 </div>
						 <div class="form-group">
						    <label for="name">操作时间</label>
						    <input type="text" class="form-control" name="dealOptionTime" placeholder="请输入操作时间">
						 </div>
						 <div class="form-group">
						    <label for="name">买入说明</label>
						    <textarea class="form-control" rows="3" name="note"></textarea>
						 </div>
						 <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-default">保存</button>
						    </div>
						 </div>
					</div>
				</form>
		</div>
</div>

<jsp:include page="./include/foot.jsp"></jsp:include>

<script type="text/javascript">
	if("${msg}"){
		layer.msg("${msg}");
	}


</script>

</body>
</html>