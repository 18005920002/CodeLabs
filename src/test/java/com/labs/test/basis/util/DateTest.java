package com.labs.test.basis.util;

import com.labs.common.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Date;


/**
 * @author win10
 * @Description
 * @Date 2018/9/28 09:19
 */
public class DateTest {

    @Test
    public void testDate() {

        Logger logger = LoggerFactory.getLogger(DateTest.class);
        /*String dateString = DateUtils.getCurrentDateStr();
        List<Date> ommitDate = new ArrayList<>();
        ommitDate.add(DateUtils.dateString2Date("2018-10-2"));
        ommitDate.add(DateUtils.dateString2Date("2018-10-3"));
        ommitDate.add(DateUtils.dateString2Date("2018-10-4"));

        logger.info("DATE:{}",dateString);*/
        String ds01 = "2018-10-1";
        String ds02 = "2018-10-2";
        String ds03 = "2018-10-3";
        String ds04 = "2018-10-4";
        String ds05 = "2018-10-5";

        Date d01 = DateUtils.dateString2Date(ds01);
        Date d02 = DateUtils.dateString2Date(ds02);
        Date d03 = DateUtils.dateString2Date(ds03);
        Date d04 = DateUtils.dateString2Date(ds04);
        Date d05 = DateUtils.dateString2Date(ds05);


        logger.info("COMAPRE:{}", d02.compareTo(d01));
        logger.info("COMAPRE:{}", d02.compareTo(d02));
        logger.info("COMAPRE:{}", d02.compareTo(d03));
        /*String ignoreDateString = ",2018-10-2,"; //"2018-10-2,2018-10-3,2018-10-4";
        List<Date> ignoreOrderDate = new ArrayList<>();
        if(null!=ignoreDateString){
            for(String ds:ignoreDateString.split(",")){
                Date date = DateUtils.dateString2Date(ds);
                if(date!=null){
                    ignoreOrderDate.add(date);
                }
            }
        }


        if(ignoreOrderDate.contains(d01)){
            logger.info("{} in ommitDate",ds01);
        }
        if(ignoreOrderDate.contains(d02)){
            logger.info("{} in ommitDate",ds02);
        }
        if(ignoreOrderDate.contains(d03)){
            logger.info("{} in ommitDate",ds03);
        }
        if(ignoreOrderDate.contains(d04)){
            logger.info("{} in ommitDate",ds04);
        }
        if(ignoreOrderDate.contains(d05)){
            logger.info("{} in ommitDate",ds05);
        }
        */

        //Date today = DateUtils.dateString2Date(DateUtils.getCurrentDateStr());

        int size = 11;
        int step = 10;
        int times = (size + step - 1) / step;
        System.out.println(times);
    }
}
