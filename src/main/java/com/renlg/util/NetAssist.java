/*
 * Project: portal
 * 
 * File Created at 2016年9月23日
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

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;

/**
 * 
 *
 * @author renlinggao
 * @Date 2017年5月12日
 */
public class NetAssist {
    private static Logger log = Logger.getLogger(NetAssist.class);

    public static String delegateGet(String url) {

        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        HttpMethod method = null;
        try {
            method = new GetMethod(url);
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(method.getResponseBodyAsStream(), "utf8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            }

        } catch (Exception e) {
            log.error("执行HTTP Get请求" + url + "时，发生异常！", e);
        } finally {
            if (method != null)
                method.releaseConnection();
        }
        return response.toString();
    }

    //    public String delegatePost(String url,Map<String, String> map) {
    //        StringBuffer response = new StringBuffer();
    //        HttpClient client = new HttpClient();
    //        PostMethod method = null;
    //        try {
    //            method = new PostMethod(url);
    //            NameValuePair[] params = new NameValuePair[map.size()];
    //            int i = 0;
    //            for(String key:map.keySet()){
    //            	params[i++] = new NameValuePair(key,map.get(key));
    //            }
    //            method.setRequestBody(params);;
    //            client.executeMethod(method);
    //            if (method.getStatusCode() == HttpStatus.SC_OK) {
    //            	response200(method,response);
    //            }
    //            
    //            if(method.getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY){
    //            	Header header = method.getResponseHeader("location");
    //                if (header != null) {
    //                    String newuri = header.getValue();
    //                    GetMethod redirect = new GetMethod(newuri);
    //                    client.executeMethod(redirect);
    //                    if (redirect.getStatusCode() == HttpStatus.SC_OK) {
    //                    	response200(redirect,response);
    //                    }
    //                    System.out.println("Redirect:"+ redirect.getStatusLine().toString());
    //                    redirect.releaseConnection();
    //                    return newuri;
    //                }
    //            }
    //
    //        } catch (Exception e) {
    //        	e.printStackTrace();
    //            log.error("执行HTTP Get请求" + url + "时，发生异常！", e);
    //            return ResultJson.failureJsonData("执行HTTP POST请求" + url + "时，发生异常！" + e.getMessage());
    //        } finally {
    //            if (method != null)
    //                method.releaseConnection();
    //        }
    //        return response.toString();
    //    }

    //    public void response200(HttpMethod method,StringBuffer response) throws IOException{
    //    	BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "utf8"));
    //    	String line;
    //    	while ((line = reader.readLine()) != null) {
    //    		response.append(line);
    //    	}
    //    	reader.close();
    //    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年9月23日 张秋扬 create
 */
