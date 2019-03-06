package com.labs.common.util;

/**
 * Description
 *
 * @author tanyun.zheng
 * @version v1.0 2019/1/30 16:26
 */
public class EnumUtil {
    public static void main(String[] args) {
        DeliveryStatusEnum[] s = DeliveryStatusEnum.values();
        for(DeliveryStatusEnum e:DeliveryStatusEnum.values()){
            System.out.println(e.getVal()+e.getLabel()+e.name());
        }

    }
}
