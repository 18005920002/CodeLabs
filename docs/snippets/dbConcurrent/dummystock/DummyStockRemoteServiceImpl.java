package com.labs.dummystock;

import com.lucky.stock.common.dto.tools.DummyStockDTO;
import com.lucky.stock.common.service.tools.DummyStockRemoteService;
import com.ucarinc.framework.dubbo.config.annotation.UService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
@UService(retries = 0, timeout = 15000)
public class DummyStockRemoteServiceImpl implements DummyStockRemoteService {
    @Autowired
    DummyStockService dummyStockService;

    @Override
    public Boolean adjust(DummyStockDTO dto) {
        return dummyStockService.adjust(dto);
    }
}
