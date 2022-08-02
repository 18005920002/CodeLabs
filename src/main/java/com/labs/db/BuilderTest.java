package com.labs.db;

import com.alibaba.fastjson.JSON;
import com.labs.db.po.ShopUnfreezeHistory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/2
 */
@Slf4j
public class BuilderTest {
    public static void main(String[] args) {
        ShopUnfreezeHistory history = ShopUnfreezeHistory.builder().id(123L)
                .autoFinish(1).orign(1).remark("remark").unfreezeNo("1234").build();
        log.info(JSON.toJSONString(history));
    }
}
