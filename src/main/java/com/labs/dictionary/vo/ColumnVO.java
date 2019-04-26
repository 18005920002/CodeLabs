package com.labs.dictionary.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 列信息
 *
 * @author tanyun.zheng
 * @version v1.0 2019/4/2 13:52
 */
@Getter
@Setter
public class ColumnVO {
    //TABLE_NAME,COLUMN_NAME,COLUMN_COMMENT,DATA_TYPE,COLUMN_TYPE,IS_NULLABLE
    /**
     * 表名
     */
    private String tableName;
    /**
     * 列名
     */
    private String columnName;
    /**
     * 列注释
     */
    private String columnComment;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 数据类型-带长度
     */
    private String columnType;
    /**
     * 是否可空（YES,NO）
     */
    private String isNullable;
}
