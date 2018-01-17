package com.jzc.spring.mvc.web;

import com.jzc.spring.mvc.exception.ServiceException;

public class ResponseModel<T> {

    private String code;

    private String msg;

    private String errorMsg;

    private T data;

    public ResponseModel(String code, String msg, String errorMsg, T data) {
        this.code = code;
        this.msg = msg;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public static <T> ResponseModel<T> returnObjectSuccess(T t) {
        return new ResponseModel<>(ResponseCode.SUCCESS, ResponseCode.SUCCESS_MSG, "", t);
    }

    public static <T> ResponseModel<T> returnException(Exception e) {
        if(e instanceof ServiceException) {
            ServiceException se = (ServiceException) e;
            return new ResponseModel<>(se.getCode(), se.getMsg(), se.getErrorMsg(), null);
        } else if (e instanceof IllegalArgumentException) {
            return new ResponseModel<>(ResponseCode.ERROR, ResponseCode.ERROR_MSG, ResponseCode.ERROR_MSG, null);
        } else {
            return new ResponseModel<>(ResponseCode.ERROR, ResponseCode.ERROR_MSG, ResponseCode.ERROR_MSG, null);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
