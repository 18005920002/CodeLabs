package com.labs.java8.api;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/9/15
 */
@Slf4j
public class LocalDateTimeUsage {
    public static void dateApi() {
        log.info("date");
        LocalDate today = LocalDate.now();
        log.info(today.toString());
    }

    public static void timeApi() {
        log.info("time");
        LocalTime t = LocalTime.now();
        log.info(t.toString());
    }

    public static void dateTimeApi() {
        log.info("dateTime");
        LocalDateTime ldt = LocalDateTime.now();

        log.info(ldt.toString());
        log.info(ldt.format(DateTimeFormatter.BASIC_ISO_DATE));
    }

    public static void main(String[] args) {
        dateApi();
        timeApi();
        dateTimeApi();
    }
}
