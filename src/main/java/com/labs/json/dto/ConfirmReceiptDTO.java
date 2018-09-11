package com.labs.json.dto;

import java.io.Serializable;
import java.util.List;

public class ConfirmReceiptDTO implements Serializable {
    private String invoiceNo;
    private Long cellId;
    private List<ConfirmGoodsDTO> goodsDetails;
    private Long operatorId;
    private String operatorName;
    private Integer operatorType;
    private Integer operatorOrigin;
    private String operatorDept;

    public ConfirmReceiptDTO() {
    }

    public String getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Long getCellId() {
        return this.cellId;
    }

    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }

    public List<ConfirmGoodsDTO> getGoodsDetails() {
        return this.goodsDetails;
    }

    public void setGoodsDetails(List<ConfirmGoodsDTO> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public Long getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return this.operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Integer getOperatorType() {
        return this.operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public Integer getOperatorOrigin() {
        return this.operatorOrigin;
    }

    public void setOperatorOrigin(Integer operatorOrigin) {
        this.operatorOrigin = operatorOrigin;
    }

    public String getOperatorDept() {
        return this.operatorDept;
    }

    public void setOperatorDept(String operatorDept) {
        this.operatorDept = operatorDept;
    }
}
