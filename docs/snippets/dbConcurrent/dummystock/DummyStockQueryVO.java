package com.labs.dummystock;

import com.zuche.framework.annotation.IbatisAliasConfig;
import lombok.Data;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
@Data
@IbatisAliasConfig(alias = "dummyStockQueryVO")
public class DummyStockQueryVO {

    private Long id;
    private Long shopId;
    private Long goodsId;
    private Long specId;

    public static DummyStockQueryVO of(Long shopId, Long goodsId, Long specId) {
        DummyStockQueryVO vo = new DummyStockQueryVO();
        vo.setShopId(shopId);
        vo.setGoodsId(goodsId);
        vo.setSpecId(specId);
        return vo;
    }
}
