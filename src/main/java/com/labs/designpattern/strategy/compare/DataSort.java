package com.labs.designpattern.strategy.compare;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * 排序方法�?
 *
 * @author win10
 */
public class DataSort {


    /**
     * 对整型数组进行排�?
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 比较具体的类
     *
     * @param arr
     */
    public static void sort(Person[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j].salary < arr[j + 1].salary) {
                    Person t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }

            }
        }
    }

    /**
     * 比较具有Comparable接口的对�?
     *
     * @param arr
     */
    public static void sort(IComparable[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    IComparable t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }

            }
        }
    }

    /**
     * 使用比较�?
     *
     * @param arr
     * @param comparator
     */
    public static void sort(Object[] arr, IComparator comparator) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    Object t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }

            }
        }
    }


    public static void main(String[] args) {
        int[] ori = {3, 9, 2, 8, 5, 7};
        sort(ori);
        System.out.println("SORTED:");
        for (int i : ori) {
            System.out.println(i + ",");
        }

        System.out.println("--------Person sort by [salary]--------");
        Person p1 = new Person("xiaoli", 12, 2000);
        Person p2 = new Person("xiaozhang", 15, 4000);
        Person p3 = new Person("xiaowang", 17, 9000);
        Person p4 = new Person("xiaoliu", 19, 7000);
        Person p5 = new Person("xiaohuang", 21, 5000);

        Person[] p = {p1, p2, p3, p4, p5};
        sort(p);
        for (Person x : p) {
            System.out.println(x);
        }

        System.out.println("--------CompareablePerson sort by [salary]--------");
        ComparablePerson cp1 = new ComparablePerson("xiaoli", 12, 2000);
        ComparablePerson cp2 = new ComparablePerson("xiaozhang", 15, 4000);
        ComparablePerson cp3 = new ComparablePerson("xiaowang", 17, 9000);
        ComparablePerson cp4 = new ComparablePerson("xiaoliu", 19, 7000);
        ComparablePerson cp5 = new ComparablePerson("xiaohuang", 21, 5000);

        ComparablePerson[] cp = {cp1, cp2, cp3, cp4, cp5};
        sort(cp);
        for (ComparablePerson x : cp) {
            System.out.println(x);
        }

        System.out.println("--------Comparator sort by [age]------");
        sort(p, new PersonAgeComparator());
        for (Person x : p) {
            System.out.println(x);
        }

    }


}
