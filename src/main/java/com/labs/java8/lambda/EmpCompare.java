package com.labs.java8.lambda;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/6
 */
public class EmpCompare {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                Employee.builder().age(18).name("zhangsan").salary(3333.33).build(),
                Employee.builder().age(49).name("lisi").salary(4444.44).build(),
                Employee.builder().age(35).name("wangwu").salary(6666.66).build(),
                Employee.builder().age(25).name("zhaoliu").salary(2222.22).build(),
                Employee.builder().age(35).name("xiaoliu").salary(1111.11).build(),
                Employee.builder().age(45).name("tianqi").salary(5555.55).build()
        );
        Collections.sort(employeeList, (x1, x2) -> {
            if (x1.getAge().compareTo(x2.getAge()) == 0) {
                return x1.getName().compareTo(x2.getName());
            } else {
                return x1.getAge().compareTo(x2.getAge());
            }
        });

        System.out.println(JSON.toJSONString(employeeList));
    }
}
