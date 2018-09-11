//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.labs.json.dto;

import java.io.Serializable;

public class ConfirmGoodsDTO implements Serializable {
    private String unifiedCode;
    private Long specId;
    private String specName;
    private Long brandId;
    private String brandName;
    private Long goodsId;
    private String goodsName;
    private Double shipmentQuantity;
    private Double recQuantity;
    private String supplierDetail;
    private Long largeClass;
    private String largeClassName;
    private Long smallClass;
    private String smallClassName;
    private Long purchaseUnit;

    public ConfirmGoodsDTO() {
    }

    public String getUnifiedCode() {
        return this.unifiedCode;
    }

    public void setUnifiedCode(String unifiedCode) {
        this.unifiedCode = unifiedCode;
    }

    public Long getSpecId() {
        return this.specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return this.specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getShipmentQuantity() {
        return this.shipmentQuantity;
    }

    public void setShipmentQuantity(Double shipmentQuantity) {
        this.shipmentQuantity = shipmentQuantity;
    }

    public Double getRecQuantity() {
        return this.recQuantity;
    }

    public void setRecQuantity(Double recQuantity) {
        this.recQuantity = recQuantity;
    }

    public String getSupplierDetail() {
        return this.supplierDetail;
    }

    public void setSupplierDetail(String supplierDetail) {
        this.supplierDetail = supplierDetail;
    }

    public Long getLargeClass() {
        return this.largeClass;
    }

    public void setLargeClass(Long largeClass) {
        this.largeClass = largeClass;
    }

    public String getLargeClassName() {
        return this.largeClassName;
    }

    public void setLargeClassName(String largeClassName) {
        this.largeClassName = largeClassName;
    }

    public Long getSmallClass() {
        return this.smallClass;
    }

    public void setSmallClass(Long smallClass) {
        this.smallClass = smallClass;
    }

    public String getSmallClassName() {
        return this.smallClassName;
    }

    public void setSmallClassName(String smallClassName) {
        this.smallClassName = smallClassName;
    }

    public Long getPurchaseUnit() {
        return this.purchaseUnit;
    }

    public void setPurchaseUnit(Long purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }
}
