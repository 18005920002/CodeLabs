package com.labs.app.concurrent;

/**
 * @Description: 库存信息
 * @Author: tanyun.zheng
 * @Date: 2019/8/22 12:09
 */
public class Stock {

    public Stock(){}

    public Stock(Integer stock){
        this.stock = stock;
    }

    private Integer stock;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public  Boolean subStock(Integer userId){
        if(stock==0){
            System.out.println("已售罄");
            return Boolean.FALSE;
        }
        --stock ;
        Double price=29.9;

        if(stock>50){
            price =19.9;
        }

        if(stock>80){
            price=9.9;
        }
        System.out.println("User-"+ userId +" buy @ price: "+price);
        return Boolean.TRUE;
    }

}
