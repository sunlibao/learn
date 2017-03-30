//配置加载信息
require.config({
	baseUrl:$ctx+"/static/",
    paths : {
    	"text":"lib/require/text",
        "jquery" : ["http://libs.baidu.com/jquery/2.0.3/jquery","lib/jquery-3.2.0"],
        "knockout":["lib/knockout-3.4.2"],
        "director":["lib/director/director"]
    }
});