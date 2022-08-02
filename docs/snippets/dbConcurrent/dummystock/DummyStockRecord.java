package com.labs.dummystock;

import com.zuche.framework.annotation.IbatisAliasConfig;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
@Data
@IbatisAliasConfig(alias = "dummyStockRecord")
public class DummyStockRecord {
    private Long id;
    private Long shopId;
    private Long goodsId;
    private Long specId;
    private BigDecimal totalCount;
    private BigDecimal adjustCount;
    private BigDecimal before;
    private BigDecimal after;
    private String threadName;

    public String toString() {
        return threadName + ": totalCount=" + totalCount
                + "adjustCount=" + adjustCount + ",before=" + before + ",after=" + after;
    }
}
