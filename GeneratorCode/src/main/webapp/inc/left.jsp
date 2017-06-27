<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单页面</title>
</head>
<body>

<div>
	<ul>
		<li>
			<sec:authorize ifAllGranted="ROLE_ROLE">
				<a id="roleMangetment" href="/role/roleList.do"   class="menu"  target="main" >菜单管理</a>
			</sec:authorize>
		</li>
	</ul>
</div>
	
	
<script type="text/javascript">

function show(){
	
	
	
}



</script>



</body>
</html>