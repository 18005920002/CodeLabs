package com.labs.practice;

import com.labs.annotation.Recommend;
import org.testng.collections.Maps;

import java.util.Map;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/8/27
 */
@Recommend
public class MapUseage {
    Map<Long, String> map;

    /**
     * 默认值规则
     * 节点存在，则使用node.value
     * 节点不存在，则使用default value
     */
    public void getValueOfNullKey() {
        initMap();
        System.out.println("key为null:" + map.get(null));
        System.out.println("key不存在:" + map.get(5L));
        System.out.println("key类型不匹配:" + map.get(1));
        System.out.println("val为null:" + map.get(4L));
        System.out.println("key为null-默认值:[节点不存在]" + map.getOrDefault(null, "DEFAULT"));
        System.out.println("key不存在-默认值:[节点不存在]" + map.getOrDefault(5L, "DEFAULT"));
        System.out.println("key类型不匹配-默认值:[节点不存在]" + map.getOrDefault(1, "DEFAULT"));
        System.out.println("val为null-默认值:[节点存在]" + map.getOrDefault(4L, "DEFAULT"));
        System.out.println("正常命中:" + map.getOrDefault(1L, "DEFAULT"));
    }

    public void initMap() {
        map = Maps.newHashMap();
        map.putIfAbsent(1L, "ValueHit-A");
        map.putIfAbsent(2L, "ValueHit-B");
        map.putIfAbsent(3L, "ValueHit-C");
        map.putIfAbsent(4L, null);
    }

    public static void main(String[] args) {
        new MapUseage().getValueOfNullKey();
    }
}
