package com.labs.dummystock;

import com.lucky.stock.api.bo.shopstock.ShopGoodsStockBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/30
 */
@Service
public class ConcurrentUpdateServiceImpl implements ConcurrentUpdateService {
    @Autowired
    ConcurrentDAO concurrentDAO;
    @Autowired
    ApplicationContext applicationContext;

    public ConcurrentUpdateServiceImpl contextMe() {
        return applicationContext.getBean(ConcurrentUpdateServiceImpl.class);
    }

    @Override
    public void updateData() {


        new Thread(new Runnable() {
            @Override
            public void run() {
                contextMe().updateStock(10000);
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                contextMe().updateStock(0);
            }
        }).start();
    }

    @Override
    @Transactional
    public void updateStock(int sleep) {
        /*try {
            if(sleep!=0){
                Thread.sleep(sleep);
                System.out.println("=========================\n"+Thread.currentThread().getName()+" Sleep...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("=========================\n" + Thread.currentThread().getName() + " working...");

        ShopGoodsStockBO bo = new ShopGoodsStockBO();
        bo.setShopDeptId(245050L);
        bo.setGoodsId(3071L);
        bo.setTotalCount(10.0);
        bo.setSaleableCount(10.0);
        concurrentDAO.updateStock(bo, sleep);
    }
}
