/*
 * Project: door
 * 
 * File Created at 2017年5月15日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.renlg.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Type DateUtil.java
 * @Desc 
 * @author renlinggao
 * @date 2017年5月15日 上午10:24:52
 * @version 
 */
public class DateUtil {
    private static SimpleDateFormat fomart1 = new SimpleDateFormat("yyyy年MM月dd日");
    
    private static String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
   
    /**
     * 获取日期格式的字符串
     * @param date
     * @return
     */
    public static final String getDateString(Date date){
        return fomart1.format(date);
    }
    
    /**
     * 获取星期几
     * @param date
     * @return
     */
    public static final String getWeekDayString(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年5月15日 renlinggao create
 */