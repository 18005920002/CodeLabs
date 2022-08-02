package com.labs.jdk5.app;

import java.util.Collection;

/**
 * Java的泛型是在编译阶段实现的
 *
 * @author win10
 */
public class CustomGeneric {

    public static void main(String[] args) {

        add(1, 2); // 类型推断
        add(1, 2.5); // 类型推断(int,float --> Number)
        add(3, "abc"); // 类型推断(int,String --> Object)

        String[] strArray = {"aaa", "bbb", "ccc"};
        Integer[] iArray = {999, 333, 222, 444, 555};
        // int[] iArray = {999,333,222,444,555};//泛型不能为基本数据类型,只能是引用数据类型

        swap(strArray, 0, 2);
        swap(iArray, 2, 4);

        Object obj = "xxx";
        String sobj = autoConvert(obj);

    }

    public static <T> T add(T a, T b) {
        return null;
    }

    /**
     * 带有泛型方法的定义 交换数组中两个元素的位置
     *
     * @param i
     * @param j
     */
    public static <T /* extends Number */> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        for (T o : a) {
            System.out.println(o);
        }
    }

    /**
     * 将对象转为任意指定类型的对象并返回
     *
     * @param obj
     * @return
     */
    public static <T> T autoConvert(Object obj) {
        return (T) obj;
    }

    /**
     * 将任意类型的对象填充到一个该类型的数组中
     *
     * @param arr
     * @param obj
     */
    public static <T> void fillArray(T[] arr, T obj) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = obj;
        }
    }

    /**
     * 将数组A安全拷贝到数组B
     *
     * @param src
     * @param dest
     */
    public static <T> void safeCopyArray(T[] src, T[] dest) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    /**
     * 将数组A安全拷贝到Collection
     * src dest数据类型不同的时候，取公共父类
     *
     * @param src
     * @param dest
     */
    public static <T> void safeCopyColl(T[] src, Collection<T> dest) {
        for (int i = 0; i < src.length; i++) {
            dest.add(src[i]);
        }
    }


}