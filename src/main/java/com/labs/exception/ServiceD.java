package com.labs.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tanyun.zheng
 * @date 2020/11/9 9:28
 */
@Slf4j
public class ServiceD {
    public void doWithException() {
        throw new BusinessRuntimeException("x");
    }
}
