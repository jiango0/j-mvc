package com.jzc.spring.mvc.exception;

/**
 * ServiceException 通用报错实体类
 * */
public class ServiceException extends IllegalArgumentException {

    private String code;
    private String msg;
    private String errorMsg;

    public ServiceException(String code, String msg, String errorMsg) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.errorMsg = errorMsg;
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
}
