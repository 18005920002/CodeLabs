package com.labs.dummystock;

import com.lucky.stock.common.dto.tools.DummyStockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
@Controller
@RequestMapping("/tools/dummystock")
public class DummyStockController {
    @Autowired
    DummyStockService dummyStockService;

    @RequestMapping(value = "/adjust", method = RequestMethod.GET)
    public void adjust(Integer count) {
        //http://stockwebtest.luckycoffee.com/luckystockweb/tools/dummystock/adjust?count=1
        DummyStockDTO dto = new DummyStockDTO();
        dto.setShopId(1L);
        dto.setGoodsId(1L);
        dto.setSpecId(11L);
        dto.setAdjustCount(count.doubleValue());
        dummyStockService.adjust(dto);
    }
}
