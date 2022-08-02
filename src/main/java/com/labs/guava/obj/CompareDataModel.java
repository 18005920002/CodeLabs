package com.labs.guava.obj;

import org.testng.collections.Sets;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/21
 */
public class CompareDataModel {
    public static void main(String[] args) {
        DataModel m1 = new DataModel();
        DataModel m2 = new DataModel();

        if (m2.equals(m1)) {
            System.out.println("Equals");
        } else {
            System.out.println("Not Equal");
        }

        Set<DataModel> dataSets = Sets.newHashSet();
        dataSets.add(m1);
        dataSets.add(m2);

    }
}
