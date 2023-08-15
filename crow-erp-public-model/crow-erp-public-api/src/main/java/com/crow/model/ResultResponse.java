package com.crow.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 前后的响应交互
 * @PackageName:IntelliJ IDEA
 * @ClassName:ResultResponse
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/11 17:13
 * @Role
 */
@Data
public class ResultResponse implements Serializable {
    private Integer code;   // 响应状态码
    private Boolean err;    // 是否存在异常
    private String message; // 携带消息
    private Object data;    // 携带数据

    public ResultResponse() {
        this.code = 333;
        this.err = false;
        this.message = "系统繁忙";
        this.data = "系统繁忙";
    }

    /**
     * 请求成功 200
     * @param date 携带数据
     */
    public ResultResponse(Object date) {
        this.code = 200;
        this.err = false;
        this.message = "请求成功";
        this.data = date;
    }

    /**
     * 自定义
     * @param code 响应状态码
     * @param err  是否存在错误 false 无错误 truw 存在错误
     * @param message  携带消息  存在异常必须携带
     * @param date     携带数据
     */
    public ResultResponse(Integer code, Boolean err, String message, Object date) {
        this.code = code;
        this.err = err;
        this.message = message;
        this.data = date;
    }

    /**
     * 数据错误异常  444
     * @param message 携带数据错误提示消息 存在数据异常必须携带
     */
    public ResultResponse(String message){
        this.code = 333;
        this.err = true;
        this.message = message;
        this.data = null;
    }

    /**
     * 错误
     * @param code  状态码
     * @param message 携带提示消息
     */
    public ResultResponse(Integer code, String message){
        this.code = code;
        this.err = true;
        this.message = message;
        this.data = null;
    }

    /**
     * @param code  状态码
     * @param data  携带数据
     */
    public ResultResponse(Integer code, Object data){
        this.code = code;
        this.err = true;
        this.message = "请求成功";
        this.data = data;
    }
}
