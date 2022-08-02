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
@IbatisAliasConfig(alias = "dummyStock")
public class DummyStock {
    private Long id;
    private Long shopId;
    private Long goodsId;
    private Long specId;
    private BigDecimal totalCount;
    private BigDecimal adjustCount;

    public String toString() {
        return "totalCount=" + totalCount + ",adjustCount=" + adjustCount;
    }
}
