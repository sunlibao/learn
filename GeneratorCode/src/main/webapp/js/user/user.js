
	/* var time = "00:00";
	
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
	 */
	 
	$(document).ready(function(){
		 $("#loginButton").click(function(){
				
				saveAjax("user/login",{"userName":"sunlibao","password":"123456"},
						function(msg){
						console.log(msg);
				},function error(){
					console.log("111");
				});
				
			});
			 
		 }
	 );
	
	 
	
	 
