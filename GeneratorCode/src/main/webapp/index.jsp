<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type='text/javascript' src='${ctx}/static/js/lib/jquery-3.2.0.js'></script>
<script type='text/javascript' src='${ctx}/static/js/lib/require/require.js'></script>
<script type='text/javascript' src='${ctx}/static/js/lib/require/config.js'></script>
<script type='text/javascript' src='${ctx}/static/js/lib/director/director.js'></script>

</head>
<body>

	<h3>代码生成器</h3>
	<div id="login">
		<div>
			<span>用户名:</span>
			<input name="username" />
		</div>
		<div>
			<span>密&nbsp;码:</span>
			<input name="password"  />
		</div>
		<button id="loginButton" >登录</button>
	</div>
	
	<script type="text/javascript">
	
	//进行路由配置--begin
	//动态注册前端路由
    window.router = new Router({});
    window.router.type = {
        html: "html",
        jsp: "jsp",
        dir: "dir",
        blank: "blank",
        flex: "flex"
    };
    window.addRouter = function(type, code, name, path, params) {
        var url = "/" + code;//当前资源编码
        var func = function() {
            //判断是否带参数，如果带参数，自动拼装成参数对象,其中arguments一定比config.params数组要小，因为如果大于的话，根本进不了方法
            var param = undefined;
            if(arguments.length > 0) {
                param = {};
                for(var n = 0; n < arguments.length; n++) {
                    param[params[n]] = arguments[n];
                }
            }
            //调用加载页面方法
            if(type.toLowerCase() == router.type.html) {
                initPage(code, name, path, param);
            }else if(type.toLowerCase() == router.type.jsp) {
               // initEmbedPage(code, name, path, param);
            }else if(type.toLowerCase() == router.type.blank) {
                //openOtherWin(code, name, path, param)
            }else if(type.toLowerCase() == router.type.flex) {
                //renderHomepageMenuItem(code);
                //setCaption(name);
                //application.visit(code, path);
            }
        };
        if(params != undefined && params.length > 0) {
            for(var i = 0; i < params.length; i++) {
                url += "/:" + params[i];//把参数加入url中
            }
        }
        window.router.on(url, func);
    };
	
    
  //加载页面
    window.initPage = function(code, name, path, param) {
     
        require([path], function(module) {
            
        	alert(122);
        	console.log(module);
        	
        	
        });
    };
    
	
	addRouter("test", "test", "", "/html/test/test", "");
	
	
		$("#loginButton").click(function(){
			
			 window.router.on("test",function(){
				 console.log(1234);
			 });
			
		})
	
	
	</script>
	
	
</body>
</html>