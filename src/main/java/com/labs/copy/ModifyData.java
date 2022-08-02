package com.labs.copy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: TODO
 * @Author: tanyun.zheng
 * @Date: 2019/8/29 11:24
 */
public class ModifyData {
    public static void main(String[] args) {

        List<DataObj> dList = Lists.newArrayList();
        DataObj d01 = new DataObj(new BigDecimal("20.1"), "L01", 1L);
        DataObj d02 = new DataObj(new BigDecimal("25.1"), "L02", 2L);
        DataObj d03 = new DataObj(new BigDecimal("30.1"), "L03", 3L);
        DataObj d04 = new DataObj(new BigDecimal("35.1"), "L04", 4L);
        DataObj d05 = new DataObj(new BigDecimal("40.1"), "L05", 5L);
        dList.add(d01);
        dList.add(d02);
        dList.add(d03);
        dList.add(d04);
        dList.add(d05);

        for (DataObj item : dList) {
            BigDecimal dc = item.getPrice();
            dc = new BigDecimal("20");
            System.out.println(JSON.toJSONString(item));
        }
    }
}
