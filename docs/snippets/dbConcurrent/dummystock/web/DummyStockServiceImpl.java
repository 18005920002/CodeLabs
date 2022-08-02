package com.labs.dummystock.web;

import com.lucky.stock.common.dto.tools.DummyStockDTO;
import com.lucky.stock.common.service.tools.DummyStockRemoteService;
import com.ucarinc.framework.dubbo.config.annotation.UReference;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
@Service
public class DummyStockServiceImpl implements DummyStockService {

    @UReference
    DummyStockRemoteService remote;

    @Override
    public Boolean adjust(DummyStockDTO dto) {
        return remote.adjust(dto);
    }
}
