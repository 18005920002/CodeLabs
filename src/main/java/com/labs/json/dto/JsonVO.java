package com.labs.json.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class JsonVO {
    private Integer intVal;
    private BigDecimal bigDecimalVal;
    private Long longVal;
    private String stringVal;
}
