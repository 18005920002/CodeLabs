package com.labs.mock.model;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/16
 */
@Data
@Builder
public class Student {
    private Long id;
    private Integer age;
    private String name;
    private Long classId;
}
