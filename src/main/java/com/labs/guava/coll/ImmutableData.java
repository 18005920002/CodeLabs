package com.labs.guava.coll;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/18
 */
public class ImmutableData {
    public static void main(String[] args) {
        /*List<String> it = Lists.newArrayList("a","b","c");
        List<String> it2 = Lists.newArrayList("x","y","z");
        List<String> it3 = Lists.newArrayList();
        List<List> top = ImmutableList.of(it,it2);
        top.get(0).add("d");
        top.add(it3);
        System.out.println(JSON.toJSONString(top));*/


        List<String> top2 = ImmutableList.of("m", "n");
        System.out.println(JSON.toJSONString(top2));
    }
}
