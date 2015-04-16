package com.wg.common.util.lang;

import java.text.DecimalFormat;

/**
 * 数值转换工具
 * 
 * @author JUNLONG CHAN
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 * 
 */
public class NumberUtil {
    /***
     * 格式化double类型
     * @param d
     * @return
     */
    public static Double format(Double d){
        if(d == null){
            return null;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(d));
    }
}
