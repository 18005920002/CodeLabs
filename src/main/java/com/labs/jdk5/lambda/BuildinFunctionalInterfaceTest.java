package com.labs.jdk5.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大内置核心函数式接口
 * <p>
 * 消费型
 * Consumer<T>
 * void accept(T t)
 * <p>
 * 供给型
 * Supplier<T>
 * T get()
 * <p>
 * 函数型
 * Function<R,T>
 * R apply(T t)
 * <p>
 * 断言型
 * Predicate<T>
 * boolean test(T t)
 *
 * @author win10
 */
public class BuildinFunctionalInterfaceTest {

    public static void main(String[] args) {
        BuildinFunctionalInterfaceTest buildin = new BuildinFunctionalInterfaceTest();
        //consumer
        System.out.println("");
        buildin.happy(10000, (m) -> System.out.println("spend $" + m));

        //supplier
        List<Integer> ls = buildin.getNumberList(5, () -> (int) (Math.random() * 100));
        for (Integer x : ls) {
            System.out.println(x);
        }

        //function
        String newStr = buildin.strHandler("  \tx b\tc fabc ", (x) -> x.trim());
        System.out.println(newStr);

        //predicate
        List<String> oriList = Arrays.asList("hello", "world", "are", "you", "ok");
        List<String> gotList = buildin.filterStr(oriList, (s) -> s.length() > 2);
        for (String str : gotList) {
            System.out.println(str);
        }

    }

    //Consumer
    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //Supplier
    public List<Integer> getNumberList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    //Function
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


    //Predicate
    public List<String> filterStr(List<String> strList, Predicate<String> pre) {
        List<String> retList = new ArrayList<String>();
        for (String s : strList) {
            if (pre.test(s)) {
                retList.add(s);
            }
        }
        return retList;
    }
}
