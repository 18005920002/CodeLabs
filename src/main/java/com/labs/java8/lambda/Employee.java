package com.labs.java8.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/6
 */
@Data
@Builder
public class Employee {
    private Integer age;
    private String name;
    private Double salary;
}
