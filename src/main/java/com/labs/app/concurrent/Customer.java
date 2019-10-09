package com.labs.app.concurrent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.testng.annotations.Test;

/**
 * @Description: 顾客信息
 * @Author: tanyun.zheng
 * @Date: 2019/8/22 09:08
 */
@Getter
@Setter
@ToString
public class Customer {
    private Integer id;
    private String name;

    private Stock stock;

    public Customer(){}

    public Customer(Integer id){
        this.id = id;
        this.name = "User-"+id;
    }
}
