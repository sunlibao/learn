<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPEHTMLPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">  
 
<html>  
 
<head>  
 
<title>My JSP 'index.jsp' starting page</title>   
</head>  
 
<body>  
      <h3>这是首页</h3>欢迎  
    <sec:authentication property ="name"/> !  
 
        
    <a href="${ctx}/toAdmin">进入admin页面</a>
    <a href="${ctx}/toOther">进入其它页面</a>   
</body>  
 
</html>