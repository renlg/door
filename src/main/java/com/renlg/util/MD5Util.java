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
package com.renlg.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Type MD5Util.java
 * @Desc 
 * @author renlinggao
 * @date 2017年5月12日 下午1:55:44
 * @version 
 */
public class MD5Util {
    
    /**
     * MD5加密
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encrypt(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String result = "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        //编码不一样会导致加密后结果不一样
        md.update(str.getBytes("UTF8"));
        byte b[] = md.digest();
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        result = buf.toString();
        return result;
    }
    
    private static final String USER_PASSWORD_KEY = "@door@";//加密的盐
    
    /**
     * 用户密码加密方式
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encryptUserPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String str = password + USER_PASSWORD_KEY;
        return encrypt(str);
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String a = encryptUserPassword("123456");
        System.out.println(a);
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