package com.labs.practice.good;

import com.labs.exception.BusinessRuntimeException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/9/2
 */
@Slf4j
public class BusinessService {
    public static int devide() {
        int i = 2;
        int y = 2;
        int c = 0;

        try {
            i = i - 2;
            c = y / i;
        } catch (Exception e) {

            log.error("计算异常:{}", e.getMessage(), e);


            throw new BusinessRuntimeException("服务端计算异常" + e.getMessage(), e);
        }
        return c;
    }
}
