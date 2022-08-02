package com.labs.json.dto;

import java.util.Objects;

/**
 * 货物分类(大小类)
 *
 * @author win10
 * @version v1.0 2018/11/12 13:38
 */
public class GoodsClass {
    /**
     * 大类ID
     */
    private Long largeClassId;
    /**
     * 小类ID
     */
    private Long smallClassId;
    /**
     * 大类编号
     */
    private String largeClassCode;
    /**
     * 小类编号
     */
    private String smallClassCode;
    /**
     * 大类名称
     */
    private String largeClassName;
    /**
     * 小类名称
     */
    private String smallClassName;

    public GoodsClass() {
    }

    public GoodsClass(Long largeClassId, Long smallClassId) {
        this.largeClassId = largeClassId;
        this.smallClassId = smallClassId;
    }

    public Long getLargeClassId() {
        return largeClassId;
    }

    public void setLargeClassId(Long largeClassId) {
        this.largeClassId = largeClassId;
    }

    public Long getSmallClassId() {
        return smallClassId;
    }

    public void setSmallClassId(Long smallClassId) {
        this.smallClassId = smallClassId;
    }

    public String getLargeClassCode() {
        return largeClassCode;
    }

    public void setLargeClassCode(String largeClassCode) {
        this.largeClassCode = largeClassCode;
    }

    public String getSmallClassCode() {
        return smallClassCode;
    }

    public void setSmallClassCode(String smallClassCode) {
        this.smallClassCode = smallClassCode;
    }

    public String getLargeClassName() {
        return largeClassName;
    }

    public void setLargeClassName(String largeClassName) {
        this.largeClassName = largeClassName;
    }

    public String getSmallClassName() {
        return smallClassName;
    }

    public void setSmallClassName(String smallClassName) {
        this.smallClassName = smallClassName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsClass that = (GoodsClass) o;
        return Objects.equals(largeClassId, that.largeClassId) &&
                Objects.equals(smallClassId, that.smallClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(largeClassId, smallClassId);
    }
}
