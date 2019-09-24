package com.labs.test.basis.util.com.labs.test.db.enroll;

import lombok.Getter;
import lombok.Setter;

/**
 * Description
 *
 * @author tanyun.zheng
 * @version v1.0 2019/4/29 16:01
 */
@Getter
@Setter
public class SimpleShopVo {

    private String shopName;
    private Long id;
    public SimpleShopVo(String shopName,Long id){
        this.shopName = shopName;
        this.id = id;
    }
}
