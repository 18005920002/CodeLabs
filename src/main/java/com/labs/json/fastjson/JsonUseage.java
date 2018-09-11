package com.labs.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.labs.json.dto.ConfirmReceiptDTO;

/**
 * @Description:
 * @Auther: win10
 * @Date: 2018/9/11 10:40
 */
public class JsonUseage {

    public static void main(String[] args) {
        //String jsonString = "{\"cityId\":633,\"shopDepartmentId\":114200,\"userCommodityStockCheckDTOList\":[{\"commodityId\":611,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100100},{\"commodityId\":608,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100010,\"userCommodityStockAdditionDTOList\":[{\"id\":168},{\"id\":203}]},{\"commodityId\":609,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100001},{\"commodityId\":613,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100001},{\"commodityId\":619,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":617,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100001},{\"commodityId\":622,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":623,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":620,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":621,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":627,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":626,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100010,\"userCommodityStockAdditionDTOList\":[{\"id\":178},{\"id\":179}]},{\"commodityId\":625,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":624,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperatur\":100010,\"userCommodityStockAdditionDTOList\":[{\"id\":179}]},{\"commodityId\":631,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100010},{\"commodityId\":635,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100100,\"userCommodityStockAdditionDTOList\":[{\"id\":172}]},{\"commodityId\":634,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100001,\"userCommodityStockAdditionDTOList\":[{\"id\":182},{\"id\":213},{\"count\":1,\"id\":240},{\"id\":243},{\"count\":1,\"id\":252}]},{\"commodityId\":632,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100010,\"userCommodityStockAdditionDTOList\":[{\"id\":179},{\"id\":175}]},{\"commodityId\":581,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":590,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":593,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100010,\"userCommodityStockAdditionDTOList\":[{\"id\":175}]},{\"commodityId\":603,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100001,\"userCommodityStockAdditionDTOList\":[{\"count\":1,\"id\":246}]},{\"commodityId\":602,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100001,\"userCommodityStockAdditionDTOList\":[{\"id\":168}]},{\"commodityId\":605,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100010,\"userCommodityStockAdditionDTOList\":[{\"id\":178}]},{\"commodityId\":604,\"count\":1,\"isRecordSock\":1,\"size\":0,\"temperature\":100000},{\"commodityId\":607,\"count\":1,\"isRecordSock\":1,\"size\":1,\"temperature\":100001,\"userCommodityStockAdditionDTOList\":[{\"id\":179},{\"id\":178},{\"id\":175}]}]}";
        String str = "{\"cellId\":65,\"goodsDetails\":[{\"brandId\":11,\"brandName\":\"脉动\",\"goodsId\":12,\"goodsName\":\"汽水\",\"largeClass\":1,\"largeClassName\":\"售卖相关类\",\"purchaseUnit\":11,\"recQuantity\":10.0,\"shipmentQuantity\":10.0,\"smallClass\":4,\"smallClassName\":\"周边商品\",\"specId\":10,\"specName\":\"箱装脉动\",\"supplierDetail\":\"aaaaa\",\"unifiedCode\":\"000010000400010021001\"}],\"invoiceNo\":\"FH201805020001\",\"operatorDept\":\"测试部门！\",\"operatorId\":1,\"operatorName\":\"超级管理员\",\"operatorOrigin\":11,\"operatorType\":3}";

        ConfirmReceiptDTO dto = (ConfirmReceiptDTO) JSON.parseObject(str,ConfirmReceiptDTO.class);

        System.out.println(JSON.toJSONString(dto,SerializerFeature.WriteMapNullValue));
    }
}
