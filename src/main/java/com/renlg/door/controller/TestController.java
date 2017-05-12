/*
 * Project: door
 * 
 * File Created at 2017年5月11日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.renlg.door.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.renlg.base.BaseController;

/**
 * @Type TestController.java
 * @Desc 
 * @author renlinggao
 * @date 2017年5月11日 下午3:02:55
 * @version 
 */
@Controller
public class TestController extends BaseController {

    @RequestMapping("test")
    @ResponseBody
    public Object test(HttpServletRequest request) {
        logger.error("测试错误打印");
        return "xxx";
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年5月11日 renlinggao create
 */
