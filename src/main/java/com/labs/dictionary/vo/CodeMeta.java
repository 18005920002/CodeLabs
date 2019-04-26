package com.labs.dictionary.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 代码生成元数据
 *
 * @author tanyun.zheng
 * @version v1.0 2019/4/26 16:39
 */
@Getter
@Setter
public class CodeMeta {
    /**
     * 作者
     */
    private String author;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 包路径
     */
    private String packageName;
    /**
     * 类描述
     */
    private String description;
    /**
     * 大写驼峰实体名
     */
    private String lowerCamelEntity;
    /**
     * 小写驼峰实体名
     */
    private String upperCamelEntity;
    /**
     * 实体注释
     */
    private String entityCommnet;
    /**
     * 数据库表名
     */
    private String tableName;
    /**
     * 模板名
     */
    private String tplName;
}
