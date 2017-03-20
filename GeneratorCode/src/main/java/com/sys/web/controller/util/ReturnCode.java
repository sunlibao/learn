package com.sys.web.controller.util;

import org.omg.CORBA.NO_PERMISSION;

/**
 * 返回结果code
 * Created by sunlibao on 2016/8/8.
 */
public enum ReturnCode {

    SUCCESS("200","操作成功"),
    ERROR("500","操作失败");
    
    //编号
    private String code;
    //名称
    private String name;


     ReturnCode(String coce,String name){
        this.code = coce ;
         this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName(){
        return name;
    }
    
}
