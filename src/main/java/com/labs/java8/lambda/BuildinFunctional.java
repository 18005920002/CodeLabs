package com.labs.java8.lambda;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/6
 */
public class BuildinFunctional {

    public static void main(String[] args) {
        BuildinFunctional obj = new BuildinFunctional();
        obj.happy(1000.0, t -> System.out.println("消费了" + t + "元"));
        List iList = obj.buildArray(10, () -> new Random().nextInt(100));
        System.out.println(JSON.toJSONString(iList));
        System.out.println(obj.handleStr("abcde", (str) -> str.toUpperCase()));
        List filteredStrList = obj.filter(Arrays.asList("abcd", "asdfasdf", "asdfasdf", "aa", "bb"), (s) -> s.length() > 3);
        System.out.println(JSON.toJSONString(filteredStrList));
    }

    public void happy(Double money, Consumer<Double> con) {
        con.accept(money);
    }

    public List<Integer> buildArray(Integer num, Supplier<Integer> supplier) {
        List<Integer> iList = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            iList.add(supplier.get());
        }
        return iList;
    }

    public String handleStr(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    public List<String> filter(List<String> strList, Predicate<String> predi) {
        List<String> newList = Lists.newArrayList();
        for (String s : strList) {
            if (predi.test(s)) {
                newList.add(s);
            }
        }
        return newList;
    }
}
