package com.labs.basis.copy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 有关BigDecimal的测试
 *
 * @author win10
 * @version v1.0 2018/12/5 11:37
 */
public class BigDecimalExplore {
    public static void main(String[] args) {
        /*BigDecimal init = BigDecimal.ZERO;

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
        System.out.println(zero);*/


        /*BigDecimal b = new BigDecimal(n3).setScale(1,RoundingMode.HALF_DOWN);
        System.out.println("b="+b);*/
        /**
         * 四舍六入五成双
         */
        String n1 = "1.25";
        String n2 = "1.55";
        String n3 = "1.65";
        String n4 = "2.50000";
        String n5 = "2.500000000100";
        String n6 = "2.55";
        String n7 = "2.549";
        String n9= "16.666";
        String n8 = "888800008888000088880000888811118888000088880000888800008888.8888111122222333344440000";

        final int ROUND_MODE = BigDecimal.ROUND_HALF_EVEN;
        System.out.println(new BigDecimal(n1).setScale(1,ROUND_MODE));
        System.out.println(new BigDecimal(n2).setScale(1,ROUND_MODE));
        System.out.println(new BigDecimal(n3).setScale(1,ROUND_MODE));
        System.out.println(new BigDecimal(n4).setScale(0,ROUND_MODE));
        System.out.println(new BigDecimal(n5).setScale(0,ROUND_MODE));
        System.out.println(new BigDecimal(n6).setScale(1,ROUND_MODE));
        System.out.println(new BigDecimal(n7).setScale(1,ROUND_MODE));
        System.out.println(new BigDecimal(n7).setScale(1,ROUND_MODE));
        System.out.println("=========");
        System.out.println(new BigDecimal(n9).setScale(1,ROUND_MODE));


        BigDecimal dlyQuantity = new BigDecimal(4.0);
        BigDecimal ratio = new BigDecimal(4.0);
        //BigDecimal dlyQuantityFinal = dlyQuantity.divide(ratio, 0, BigDecimal.ROUND_HALF_EVEN);
        dlyQuantity.divide(ratio,0);
        System.out.println("dlyQuantityFinal="+dlyQuantity.divide(ratio,0,BigDecimal.ROUND_DOWN));

        System.out.println("======================");
        System.out.println("toString:"+new BigDecimal(n8).toString());
        System.out.println("toPlainString:"+new BigDecimal(n8).toPlainString());
        System.out.println("toEngineeringString:"+new BigDecimal(n8).toEngineeringString());


        Byte b1 = new Byte("5");
        Byte b2 = Byte.valueOf("5");
        if(b1.byteValue()==b2.byteValue()){
            System.out.println("B1 == B2");
        }else{
            System.out.println("B1 != B2");
        }


        if(b1==b2.byteValue()){
            System.out.println("B1 == B2");
        }else{
            System.out.println("B1 != B2");
        }

        if(b1==5){
            System.out.println("B1 == B2");
        }else{
            System.out.println("B1 != B2");
        }

        if(b1.equals(b2)){
            System.out.println("B1 == B2");
        }else{
            System.out.println("B1 != B2");
        }


    }
}
