package com.labs.dummystock;

import com.lucky.stock.common.dto.tools.DummyStockDTO;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
public interface DummyStockService {
    Boolean adjust(DummyStockDTO dto);
}
