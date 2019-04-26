package com.labs.common.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 货物计量单位按比例转换
 *
 * @author win10
 * @version v1.0 2019/1/4 18:54
 */
public class UnitConvertUtil {

    public static void main(String[] args) {

        System.out.println(DateUtils.formatDate(new Date(),"yyyyMMddHHmmss"));
        UnitConvertUtil ucu = new UnitConvertUtil();
        ucu.getText();
        System.out.println(">>>>>>>>>>");
        BigDecimal[] parts = ucu.getQuantityArray(BigDecimal.valueOf(123),BigDecimal.valueOf(1),BigDecimal.valueOf(10));
        System.out.println(parts[0]+"采购单位 "+parts[1]+"配货单位 "+parts[2]+"用料单位");
    }


    private String getText(){
        BigDecimal total = new BigDecimal("12345");

        BigDecimal ru = new BigDecimal("1");
        BigDecimal rb = new BigDecimal("10");
        String us = "个";
        String ds = "个";
        String bs = "个";
        if(null==total||total.compareTo(BigDecimal.ZERO)==0){
            return "0"+us;
        }

        BigDecimal tempBuy;
        BigDecimal use;
        BigDecimal buy;
        BigDecimal dly;
        if(ru.compareTo(BigDecimal.ONE)==0){
            //单位相同
            tempBuy = total;
            use = BigDecimal.ZERO;
            if(rb.compareTo(BigDecimal.ONE)==0){
                buy = tempBuy;
                dly = BigDecimal.ZERO;
            }else{
                buy = tempBuy.divideAndRemainder(rb)[0];
                dly = tempBuy.divideAndRemainder(rb)[1];
            }
        }else{
            tempBuy = total.divideAndRemainder(ru)[0];
            use = total.divideAndRemainder(ru)[1];
            if(rb.compareTo(BigDecimal.ONE)==0){
                buy = tempBuy;
                dly = BigDecimal.ZERO;
            }else {
                buy = tempBuy.divideAndRemainder(rb)[0];
                dly = tempBuy.divideAndRemainder(rb)[1];
            }
        }
        StringBuffer buffer=new StringBuffer();

            buffer.append(buy.stripTrailingZeros().toPlainString()).append(bs).append("采购单位 ");
            buffer.append(dly.stripTrailingZeros().toPlainString()).append(ds).append("配货单位 ");
            buffer.append(use.stripTrailingZeros().toPlainString()).append(us).append("用料单位 ");

        System.out.println(buffer.toString());
        return  buffer.toString();
    }


    /**
     * 转换计算，分别返回三个单位
     * @param total
     * @param ru
     * @param rb
     * @return
     */
    private BigDecimal[] getQuantityArray(BigDecimal total,BigDecimal ru,BigDecimal rb){

        if(null==total||total.compareTo(BigDecimal.ZERO)==0){
            return new BigDecimal[]{BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO};
        }

        BigDecimal[] qArrary =  new BigDecimal[3];
        BigDecimal tempBuy;
        BigDecimal use;
        BigDecimal buy;
        BigDecimal dly;
        if(ru.compareTo(BigDecimal.ONE)==0){
            //单位相同
            tempBuy = total;
            use = BigDecimal.ZERO;
            if(rb.compareTo(BigDecimal.ONE)==0){
                buy = tempBuy;
                dly = BigDecimal.ZERO;
            }else{
                buy = tempBuy.divideAndRemainder(rb)[0];
                dly = tempBuy.divideAndRemainder(rb)[1];
            }
        }else{
            tempBuy = total.divideAndRemainder(ru)[0];
            use = total.divideAndRemainder(ru)[1];
            if(rb.compareTo(BigDecimal.ONE)==0){
                buy = tempBuy;
                dly = BigDecimal.ZERO;
            }else {
                buy = tempBuy.divideAndRemainder(rb)[0];
                dly = tempBuy.divideAndRemainder(rb)[1];
            }
        }

        qArrary[0]=buy.stripTrailingZeros();
        qArrary[1]=dly.stripTrailingZeros();
        qArrary[2]=use.stripTrailingZeros();
        return qArrary;

    }
}
