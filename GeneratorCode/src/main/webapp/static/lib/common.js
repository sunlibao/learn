
	/**
	 * 异步保存
	 * @param _url 地址
	 * @param _data 传入参数
	 * @param _success 成功函数
	 * @param _error 错误函数
	 */
	 function saveAjax(_url,_data,_success,_error){
		
		$.ajax({
			url:_url,
			type:"POST",
			dataType:"json",
			data:{
				param:JSON.stringify(_data)
			},
			success:_success,
			error:_error
		});
		
	}

