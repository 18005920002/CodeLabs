package com.labs.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.labs.json.dto.ConfirmReceiptDTO;

/**
 *
 * Description
 * Google JSON 实例
 *
 * @author win10
 * @version 0.1 2018/9/11 11:50
 */
public class GsonUsage {

    public static void main(String[] args) {

        String str = "{\"cellId\":65,\"goodsDetails\":[{\"brandId\":11,\"brandName\":\"脉动\",\"goodsId\":12,\"goodsName\":\"汽水\",\"largeClass\":1,\"largeClassName\":\"售卖相关类\",\"purchaseUnit\":11,\"recQuantity\":10.0,\"shipmentQuantity\":10.0,\"smallClass\":4,\"smallClassName\":\"周边商品\",\"specId\":10,\"specName\":\"箱装脉动\",\"supplierDetail\":\"aaaaa\",\"unifiedCode\":\"000010000400010021001\"}],\"invoiceNo\":\"FH201805020001\",\"operatorDept\":\"测试部门！\",\"operatorId\":1,\"operatorName\":\"超级管理员\",\"operatorOrigin\":11,\"operatorType\":3}";

        Gson g = new Gson();

        ConfirmReceiptDTO dto = g.fromJson(str,ConfirmReceiptDTO.class);
        System.out.println(g.toJson(dto));
    }
}
