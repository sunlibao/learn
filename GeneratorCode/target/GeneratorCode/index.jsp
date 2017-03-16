<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h3>代码生成器</h3>
	
	<script type="text/javascript">
	
	var time = "00:00";
	
	function addSecond(){
		var second = time.split(":")[1];
		second = second-0+1;
		if(second <=9&&second<60){
			second = "0"+9;
			time = time.split(":")[0]+":"+second;
		}else if(second >9&&second<60){
			time = time.split(":")[0]+":"+second;
		}else if(second>=60){
			
			if(time.split(":")[0]-0<=9){
				time = time.split(":")[0]-0+1+":"+"00";
				time = "0"+time;
			}else{
				time = time.split(":")[0]-0+1+":"+"00";
			}
			
		}
		
		console.log(time);
	}
	
	window.setInterval(addSecond,100); 
	
	</script>
</body>
</html>