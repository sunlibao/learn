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
					<span>添加股票</span>
				</div>
				<form action="${ctx}/shares/saveUserShares">
					<div role="form">
						<div class="form-group">
						    <label for="name">股票代码</label>
						    <input type="number" class="form-control" name="sharesCode" placeholder="股票代码">
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