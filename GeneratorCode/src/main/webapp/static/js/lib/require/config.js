//配置加载信息
require.config({
	baseUrl:"static",
    paths : {
    	"text":"/GeneratorCode/static/js/lib/require/text",
        "jquery" : ["http://libs.baidu.com/jquery/2.0.3/jquery","/GeneratorCode/static/js/lib/jquery-3.2.0"],
        "knockout":["/GeneratorCode/static/js/lib/knockout-3.4.2.js"],
        "director":["/GeneratorCode/static/js/lib/director/director.min"]
    }
});