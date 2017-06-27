<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPEHTMLPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
<frameset rows="20%,70%,10%" cols="*">
    <frameset rows="50%" cols="*" frameborder="yes" border="1" framespacing="1">
        <frame src="${ctx}//inc/header.html"/>
    </frameset>
    <frameset rows="*" cols="300px,70%" frameborder="yes" framespacing="1">
        <frame src="${ctx}/inc/left.jsp"/>
        <frame name="main" src="${ctx}/inc/main.html"/>
    </frameset>
    <frameset rows="80%" cols="*" frameborder="yes" border="1" framespacing="1">
        <frame src="${ctx}/inc/footer.html"/>
    </frameset>
</frameset>
</html>