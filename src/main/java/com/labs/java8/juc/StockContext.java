package com.labs.java8.juc;

import lombok.Data;

import java.util.Map;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/21
 */
@Data
public class StockContext {
    Map<Long, Double> goodsStock;
}
