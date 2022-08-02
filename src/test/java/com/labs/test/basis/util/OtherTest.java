package com.labs.test.basis.util;

import com.labs.test.basis.util.com.labs.test.db.enroll.SimpleShopVo;
import org.testng.collections.Lists;

import java.util.List;

/**
 * Description
 *
 * @author win10
 * @version v1.0 2019/1/11 15:25
 */
public class OtherTest {
    public static void main(String[] args) {
       /* Integer lastDlyDaysNum = null;
        Integer dlyDaysNum = 10;

        System.out.println(dlyDaysNum.compareTo(lastDlyDaysNum));
*/
        //System.out.println(genCode("CI0008","201801"));
        /*List<SimpleShopVo> unCloseOrderShops = Lists.newArrayList();
        unCloseOrderShops.add(new SimpleShopVo("abc",1L));
        unCloseOrderShops.add(new SimpleShopVo("ASF",2L));
        unCloseOrderShops.add(new SimpleShopVo("ASdF",3L));
        unCloseOrderShops.add(new SimpleShopVo("ASDF",4L));
        int size = unCloseOrderShops.size()>3?3:unCloseOrderShops.size();
        StringBuffer shops = new StringBuffer("");
        for (int i=0;i<size;i++){
            SimpleShopVo shop = unCloseOrderShops.get(i);
            shops.append(shop.getShopName());
            if(i<size-1){
                shops.append(",");
            }
        }
        System.out.println(shops.toString());*/
        String[] arr = "NULL".split(",");
        Integer i = Integer.valueOf("");
        System.out.println(i);
    }

    static String genCode(String cityCode, String yearMonth) {
        String s = "TBQ" + cityCode.substring(2, 6) + yearMonth.substring(2, 6);
        return s;
    }


}
