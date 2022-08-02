package com.labs.designpattern.strategy.compare;

/**
 * 比较�?,实现比较逻辑的封�?
 *
 * @author win10
 */
public interface IComparator {
    /**
     * o1 > o2  compare()>0;
     * o1 < o2  compare()<0;
     *
     * @param o1
     * @param o2
     * @return
     */
    public int compare(Object o1, Object o2);
}
