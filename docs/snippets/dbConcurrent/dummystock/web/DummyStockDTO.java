package com.labs.dummystock.web;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
@Data
public class DummyStockDTO implements Serializable {
    private Long shopId;
    private Long goodsId;
    private Long specId;
    private Double adjustCount;
}
