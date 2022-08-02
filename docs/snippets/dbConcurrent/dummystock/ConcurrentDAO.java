package com.labs.dummystock;

import com.lucky.stock.api.bo.shopstock.ShopGoodsStockBO;
import com.lucky.stock.common.utils.dao.LuckyBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/30
 */
@Repository
public class ConcurrentDAO extends LuckyBaseDao {
    public void updateStock(ShopGoodsStockBO goodsStockBO, int sleep) {
        try {
            //ShopGoodsStockBO before = (ShopGoodsStockBO)this.queryForObject(sqlXml+"getStock",goodsStockBO);

            this.update(sqlXml + "updateStock", goodsStockBO);
            try {
                //事务开启，延迟没有提交
                if (sleep != 0) {
                    Thread.sleep(sleep);
                    System.out.println("=========================\n" + Thread.currentThread().getName() + " Sleeping..");
                }
            } catch (Exception e) {

            }
            ShopGoodsStockBO after = (ShopGoodsStockBO) this.queryForObject(sqlXml + "getStock", goodsStockBO);
            System.out.println("=========================\n" + Thread.currentThread().getName() + "-Total:" + after.getTotalCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
