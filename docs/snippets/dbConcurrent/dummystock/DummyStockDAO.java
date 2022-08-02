package com.labs.dummystock;

import com.lucky.stock.common.utils.dao.LuckyBaseDao;
import com.lucky.stock.local.tools.vo.DummyStock;
import com.lucky.stock.local.tools.vo.DummyStockQueryVO;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
@Repository
public class DummyStockDAO extends LuckyBaseDao {

    public DummyStock getStock(DummyStockQueryVO query) {
        return (DummyStock) this.queryForObject(sqlXml + "getStock", query);
    }

    public DummyStock getStockForUpdate(DummyStockQueryVO query) {
        return (DummyStock) this.queryForObject(sqlXml + "getStockForUpdate", query);
    }

    public int updateStock(DummyStock stock) {
        return this.update(sqlXml + "updateStock", stock);
    }
}
