/*
 * Project: door
 * 
 * File Created at 2017年5月12日
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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renlg.base.BaseController;
import com.renlg.base.Constant;
import com.renlg.base.JsonResult;
import com.renlg.user.model.User;
import com.renlg.user.service.UserService;

/**
 * @Type LoginController.java
 * @Desc 
 * @author renlinggao
 * @date 2017年5月12日 下午2:36:27
 * @version 
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param userName
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public JsonResult login(String userName, String password, HttpServletRequest request) {
        JsonResult result = new JsonResult();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            result.setSuccess(false);
            result.setMessage("账号或密码不能为空");
            return result;
        }
        User user = userService.login(userName, password);
        if (user != null) {
            request.getSession().setAttribute(Constant.SESSION_USER_KEY, user);
            result.setModel(user);
        } else {
            result.setSuccess(false);
            result.setMessage("账号或密码错误");
        }
        return result;
    }
    
    /**
     * 主页路由
     * @return
     */
    @RequestMapping("index")
    public String toIndex() {
        return "index";
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年5月12日 renlinggao create
 */
