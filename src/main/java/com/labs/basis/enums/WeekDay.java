package com.labs.basis.enums;

/**
 * 枚举的定义
 *
 * @version 0.1
 */
public enum WeekDay {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public String toString() {
        if (this == MONDAY)
            System.out.println(MONDAY.name());
        else if (this == WeekDay.TUESDAY) {
            System.out.println(TUESDAY.name());
        } else System.out.println("ERROR");
        return this.name();
    }


}
