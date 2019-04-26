package com.labs.test.basis.util;

/**
 * Description
 *
 * @author win10
 * @version v1.0 2019/1/11 15:25
 */
public class OtherTest {
    public static void main(String[] args) {
        Integer lastDlyDaysNum = null;
        Integer dlyDaysNum = 10;

        System.out.println(dlyDaysNum.compareTo(lastDlyDaysNum));

        //System.out.println(genCode("CI0008","201801"));
    }

    static String genCode(String cityCode,String yearMonth){
        String s ="TBQ"+cityCode.substring(2,6)+yearMonth.substring(2,6);
        return s;
    }
}
