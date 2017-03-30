<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script type="text/javascript">
	window.$ctx = "${ctx}";
</script>

<script type='text/javascript' src='${ctx}/static/lib/require/require.js'></script>
<script type='text/javascript' src='${ctx}/static/lib/require/config.js'></script>
<script type='text/javascript' src='${ctx}/static/lib/director/director.js'></script>
    <script>
     
     initPage = function(code) { 
    	 
    	 require(["jquery","html/test/test"],function($,module){
    		
    		 $("#show").append(module.template);
    		 
    	 });
    	 
     };

      var routes = {
        '/html/:code': initPage
      };

      var router = Router(routes);
      router.init();

    </script>
  </head>
  <body>
  <div id="main" style="width: 1024px;margin:  0 auto;">
	  	<div id="header" style="background-color: yellow;width: 1024px;">
	  		头
	  	</div>
	  	<div id="left" style="background-color: gray;width: 300px;float: left;">
	  	左侧
	  	</div>
	  	<div id="content" style="background-color:green;width:700px; float: right; ">
		  	<ul>
		      <li><a href="#/html/1">#/html/1</a></li>
		      <li><a href="#/html/2">#/html/2</a></li>
		    </ul>
		    <div id="show"></div>
	  	</div>
  </div>
  
  
    
  </body>
</html>