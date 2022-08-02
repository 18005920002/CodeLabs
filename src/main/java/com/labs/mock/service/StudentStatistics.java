package com.labs.mock.service;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/16
 */
public interface StudentStatistics {
    /**
     * 计算平均年龄
     *
     * @return
     */
    Integer getAverageAge(Long classId);
}
