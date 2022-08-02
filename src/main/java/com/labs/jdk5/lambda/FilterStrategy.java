package com.labs.jdk5.lambda;

/**
 * 策略模式
 * <p>
 * 函数式接口，接口中只有一个抽象方法，成为函数式接口
 *
 * @author win10
 */
@FunctionalInterface
public interface FilterStrategy {

    public boolean meetRequire(Employee emp);

    // public boolean x();
}  
