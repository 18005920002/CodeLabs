package com.labs.basis.copy;

import java.math.BigDecimal;

/**
 * 有关BigDecimal的测试
 *
 * @author win10
 * @version v1.0 2018/12/5 11:37
 */
public class BigDecimalExplore {
    public static void main(String[] args) {
        BigDecimal init = BigDecimal.ZERO;

        init.add(new BigDecimal(3));
        init.add(new BigDecimal(3));
        init.add(new BigDecimal(3));
        init.add(new BigDecimal(3));
        System.out.println(init);

        init = init.add(new BigDecimal(3));
        init = init.add(new BigDecimal(3));
        init = init.add(new BigDecimal(3));
        init = init.add(new BigDecimal(3));
        System.out.println(init);

        BigDecimal zero = BigDecimal.valueOf(0d);
        System.out.println(zero);

    }
}
