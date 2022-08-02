//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.labs.common.util;

public enum DeliveryStatusEnum {
    CREATE((byte) 1, "已创建"),
    SUBMIT((byte) 2, "已确认可配货数量"),
    DELIVERY((byte) 3, "已出发派送"),
    FINISH((byte) 4, "已完成"),
    CANCEL((byte) 5, "已撤销"),
    CANCELED((byte) 6, "已取消"),
    ARRIVED((byte) 7, "已送达");

    private final Byte val;
    private final String label;

    private DeliveryStatusEnum(Byte val, String label) {
        this.val = val;
        this.label = label;
    }

    public static DeliveryStatusEnum valueOf(Byte val) {
        DeliveryStatusEnum[] ems = values();
        DeliveryStatusEnum[] var2 = ems;
        int var3 = ems.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            DeliveryStatusEnum em = var2[var4];
            if (em.val.equals(val)) {
                return em;
            }
        }

        return null;
    }

    public Byte getVal() {
        return this.val;
    }

    public String getLabel() {
        return this.label;
    }

    public static String labelOf(Byte val) {
        DeliveryStatusEnum em = valueOf(val);
        return em != null ? em.getLabel() : "";
    }
}
