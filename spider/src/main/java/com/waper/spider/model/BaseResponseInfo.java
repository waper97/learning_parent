package com.waper.spider.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BaseResponseInfo
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/6 14:53
 */
public class BaseResponseInfo implements Serializable {

    /**
     * 成功
     */

    public static final int SUCCESS_CODE = 200;
    /**
     * 失败
     */
    public static final int FAIL_CODE = 400;
    /**
     * 异常
     */
    public static final int ABNORMAL_CODE = 500;

    /**信息*/
    private String message;
    /**状态*/
    private int status;
    /**状态码*/
    private int code;
    /**数据*/
    private Object data;
    /**额外*/
    private Object extra;
    /**是否成功*/
    private boolean success = true;
    /**当前时间*/
    private Date now = new Date();


    public BaseResponseInfo() {
    }

    public BaseResponseInfo(String message, int code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public BaseResponseInfo(String message, boolean success) {
        this.message = message;
        this.success = success;
        this.code = SUCCESS_CODE;
    }

    public BaseResponseInfo(String message, Object data, boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
        this.code = SUCCESS_CODE;
    }

    public BaseResponseInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }


}
