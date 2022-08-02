package com.labs.mock.dao;

import com.labs.mock.model.Student;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/16
 */
public class StudentStatisticsDAO {
    List<Student> listStudent(Long classId) {
        return Arrays.asList(Student.builder().id(1L).age(20).name("zhangsan").classId(4L).build(),
                Student.builder().id(2L).age(30).name("lisi").classId(2L).build(),
                Student.builder().id(3L).age(40).name("wangwu").classId(1L).build());
    }
}
