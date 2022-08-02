package com.labs.guava.obj;

import com.google.common.base.Objects;
import lombok.*;


/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/21
 */

@Getter
@Setter
public class DataModel {
    private String name;
    private Integer age;
    private Integer gentel;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("age", age)
                .add("gentel", gentel).toString();
    }

    @Override
    public boolean equals(Object obj) {
        //name
        return Objects.equal(this, obj);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }
}
