package com.labs.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;

/**
 * @author tanyun.zheng
 * @date 2020/11/9 9:28
 */
@Slf4j
public class ServiceA {
    @Test
    public void doa() {
        //try{
        new ServiceB().dob();
        /*}catch (Exception e){
            log.info("{}",e.getMessage(),e);
        }*/
    }
}
