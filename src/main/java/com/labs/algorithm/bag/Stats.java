package com.labs.algorithm.bag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * Stats.java
 * 背包的应用
 * 求均值及标准差
 *
 * @author win
 * @version 0.1 2018-10-09
 */
public class Stats {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Stats.class);
        Bag<Double> numbers = new Bag<Double>();
        numbers.add(20.20d);
        numbers.add(10.10d);
        numbers.add(30.30d);

        int n = numbers.size();
        logger.info("Bag Length:{}", n);
        Iterator<Double> it = numbers.iterator();
        while (it.hasNext()) {
            Double item = it.next();
            logger.info("Bag item:{}", item);
        }

        double sum = 0;
        for (double x : numbers) {
            sum += x;
        }
        //平均值
        double mean = sum / n;
        logger.info("Bag mean:{}", mean);

        sum = 0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        //标准差
        double std = Math.sqrt(sum / (n - 1));
        logger.info("Bag std:{}", std);

    }
}
