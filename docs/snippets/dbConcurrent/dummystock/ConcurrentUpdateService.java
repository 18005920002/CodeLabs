package com.labs.dummystock;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/30
 */
public interface ConcurrentUpdateService {
    void updateData();

    void updateStock(int sleep);
}
