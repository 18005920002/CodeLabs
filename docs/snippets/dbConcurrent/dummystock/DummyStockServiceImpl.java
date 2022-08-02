package com.labs.dummystock;

import com.alibaba.fastjson.JSON;
import com.lucky.stock.common.dto.tools.DummyStockDTO;
import com.lucky.stock.common.util.Numbers;
import com.lucky.stock.local.tools.dao.DummyStockDAO;
import com.lucky.stock.local.tools.vo.DummyStock;
import com.lucky.stock.local.tools.vo.DummyStockQueryVO;
import com.lucky.stock.local.tools.vo.DummyStockRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/28
 */
@Service
@Slf4j
public class DummyStockServiceImpl implements DummyStockService {

    @Autowired
    DummyStockDAO dummyStockDAO;

    @Override
    @Transactional
    public Boolean adjust(DummyStockDTO dto) {
        String threadName = Thread.currentThread().getName();
        //读before
        DummyStockQueryVO query = DummyStockQueryVO.of(dto.getShopId(), dto.getGoodsId(), dto.getSpecId());
        log.info("{} Reading before:{}", threadName, System.currentTimeMillis());
        DummyStock before = dummyStockDAO.getStock(query);
        log.info("{} Read before: {}", threadName, before);
        DummyStock stock = new DummyStock();
        stock.setShopId(dto.getShopId());
        stock.setGoodsId(dto.getGoodsId());
        stock.setSpecId(dto.getSpecId());
        stock.setAdjustCount(Numbers.of(dto.getAdjustCount()));
        if (dto.getAdjustCount() > 2) {
            try {
                log.info("==============={}等待 2s <<<<", threadName);
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            log.info("==============={}>>>>>>>>>>", threadName);
        }

        dummyStockDAO.updateStock(stock);
        log.info("{} Updated:{}", threadName, System.currentTimeMillis());
        //读after
        log.info("{} Reading after:{}", threadName, System.currentTimeMillis());


        DummyStock after = dummyStockDAO.getStock(query);
        log.info("{} Read after:{}", threadName, after);
        DummyStockRecord record = getRecord(before, after, Numbers.of(dto.getAdjustCount()), threadName);
        log.info("{} Record:{} @ {}", threadName, JSON.toJSONString(record), System.currentTimeMillis());
        if (dto.getAdjustCount() < 2) {
            try {
                log.info("==============={}等待 10s <<<<", threadName);
                Thread.sleep(10000);
            } catch (Exception e) {
            }
            log.info("==============={}>>>>>>>>>>", threadName);
        }
        return Boolean.TRUE;
    }

    private DummyStockRecord getRecord(DummyStock before, DummyStock after, BigDecimal adjustCount, String threadName) {
        DummyStockRecord record = new DummyStockRecord();
        record.setShopId(before.getShopId());
        record.setGoodsId(before.getGoodsId());
        record.setSpecId(before.getSpecId());
        record.setTotalCount(after.getTotalCount());
        record.setAdjustCount(adjustCount);
        record.setBefore(before.getTotalCount());
        record.setAfter(after.getTotalCount());
        record.setThreadName(threadName);
        return record;
    }
}
