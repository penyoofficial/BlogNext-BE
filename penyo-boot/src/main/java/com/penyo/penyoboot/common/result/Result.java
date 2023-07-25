package com.penyo.penyoboot.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:统一响应结构体
 * @author: 顾壮壮
 * @date: 2023/7/25 10:02
 */
@Data
public class Result<T> implements Serializable {

    private String code;

    private T data;

    private String msg;

    public static <T> Result<T> success(){
        return success(null);
    }

    private static <T> Result<T> success(T data) {
        Result<T> result=new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failed(){
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(),null,ResultCode.SYSTEM_EXECUTION_ERROR.getMsg());
    }

    public static <T> Result<T> failed(String msg) {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(),null,msg);
    }

    public static <T> Result<T> judge(boolean status) {
        if (status) {
            return success();
        } else {
            return failed();
        }
    }

    public static <T> Result<T> failed(IResultCode code){
        return result(code.getCode(),null,null);
    }

    public static <T> Result<T> failed(IResultCode code,String msg){
        return result((code.getCode()),null,msg);
    }
    public static <T> Result<T> failed(IResultCode code,T data){
        return result(code.getCode(),data,null);
    }
    public static <T> Result<T> result(String code,T data,String msg){
        Result<T> result =new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
