package com.sys.web.controller.util;



import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 参数获取帮助类
 * Created by sunlibao on 2016/8/10.  2
 */
public class ParamUtil {

    public final static BillModel parseBillModel(String param) {
        Map<String, Object> paramMap = (Map<String, Object>) JSON.parse(param);
        BillModel bill = new BillModel();
        bill.putAll(paramMap);
        return bill;
    }

    /**
     * 字符串转化为map
     *
     * @param param json字符串
     * @return
     */
    public final static Map<String, Object> parseMap(String param) {
        Map<String, Object> paramMap = (Map<String, Object>) JSON.parse(param);
        return paramMap;
    }

    


}
