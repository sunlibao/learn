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
<script type='text/javascript' src='${ctx}/static/lib/jquery-3.2.0.js'></script>
<script type="text/javascript" ></script>
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
    
    <style type="text/css">
   body {
		margin: 0px;
		padding: 0px;
		background-color: gray;
	}
	
	ul {
		list-style-type: none;
	}
	ul li{
		background-color: white;
		border-style:solid;
		border-width: 1px;
		padding-left: 30px;
	}
	
	a{
		text-decoration: none;
		color: gray;
	}
	
	#menu{
		background-color:white;
		width: 300px;
		float: left;
		height: 100%;
		min-height: 500px;
	}
	
	#content{
		background-color:white;
		width:800px; 
		float: left;
		margin-left: 25px;
		min-height: 500px;
	}
	
	
	/*菜单选项*/
	.menu_list_item{
		height: 37px;
		line-height: 37px;
		text-align: left;
	}
	
	
    </style>
    
    <script type="text/javascript">
    
    $(document).ready(function(){
    	
    	var height =  $("#content").height();
    	
    	
    	$("#menu").css("height",height);
    	
    	
    	$(".menu_list_item a").bind("click",function(){
       	 
       	 
        });
    	
    	
    });
    
    
    
    
     
   
  
    
    
    </script>
    
  </head>
  <body>
  
  <div id="header" style="background-color:blue;height: 80px;margin-bottom:20px;">
	  		
  </div>
  <div id="main" style="width:1140px;;margin:  0 auto;">
	  	<div id="menu">
	  		<ul>
	  			<li class="menu_list_item">
	  				<a href="javascipt:void(0);" code="site">
	  				<i></i>
	  					站点
	  				</a>
	  			</li>
	  			
	  		</ul>
	  	</div>
	  	<div id="content">
		  	<ul>
		      <li><a href="#/html/1">#/html/1</a></li>
		      <li><a href="#/html/2">#/html/2</a></li>
		    </ul>
		    <div id="show"></div>
	  	</div>
  </div>
  
  
    
  </body>
</html>