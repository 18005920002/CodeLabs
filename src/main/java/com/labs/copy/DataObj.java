package com.labs.copy;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Author: tanyun.zheng
 * @Date: 2019/8/29 11:23
 */
@Getter
@Setter
public class DataObj {
    private BigDecimal price;
    private String name;
    private Long goodsId;

    public DataObj(){}

    public DataObj(BigDecimal price,String name,Long goodsId){
        this.price = price;
        this.name = name;
        this.goodsId = goodsId;
    }
}
