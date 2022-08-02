package com.labs;

import com.google.common.collect.Lists;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description
 *
 * @author tanyun.zheng
 * @version v1.0 2019/5/15 17:30
 */
public class MainTest {

    /*public static void main(String[] args) {
        String s ="AB";
        System.out.println(s.hashCode());
        MainTest o = new MainTest();
        o.hashCode();
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(o);
    }*/

    /*public static void main(String[] args) {
        List<Long> list = Lists.newArrayList();
        if (!list.contains(111L)) {
            System.out.println("xxxxxxxxxx");
        } else {
            System.out.println("yyyyyyyyyy");
        }

        List<Integer> intList = Lists.newArrayList();
        for (int i = 1; i <= 101; i++) {
            intList.add(i);
        }
        int size = intList.size();
        int times = (size + 1) / 10 + 1;
        int step = 10;

        for (int i = 0; i < times; i++) {
            int start = i * step;
            int end = (i + 1) * step > size ? size : (i + 1) * step;
            List subList = intList.subList(start, end);
            System.out.println(StringUtils.join(subList, ","));
        }
    }*/


    public static void main(String[] args) {
        /*int a = 5;
        System.out.println(a);

        doTest(a);

        System.out.println(a);
        Long l = 5L;
        long v = l.longValue();

        BigDecimal d = BigDecimal.valueOf(l);*/

        String ss = "";
        BigDecimal d = new BigDecimal(ss);
        System.out.println(d);
    }

    private static void doTest(int b) {
        b = b + 5;
    }

}
