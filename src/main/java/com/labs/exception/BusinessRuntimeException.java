package com.labs.exception;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/9/2
 */
public class BusinessRuntimeException extends RuntimeException {

    public BusinessRuntimeException() {

    }

    public BusinessRuntimeException(String msg) {
        super(msg);
    }

    public BusinessRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BusinessRuntimeException(Throwable cause) {
        super(cause);
    }
}
