package com.labs.common.util;


import java.util.*;


/**
 * 对集合的常用转换核心API
 *
 * @author tanyun.zheng
 * @version v1.0 2019/3/13 20:05
 */
public class CollectionConvertExample {

    public static void main(String[] args) {
        //Arrays.asList(iArray)
        array2List();

        //iList.toArray(iArray);
        list2Array();

        //new HashSet(Arrays.asList(iArray));
        array2Set();

        //set.toArray(iArray);
        set2Array();

        //new HashSet(iList);
        list2Set();

        //new ArrayList<>(set)
        set2List();

        //Set<Map.Entry<Integer,String>> eSet = map.entrySet();
        //Set keySet = new HashSet(map.keySet());
        //Set valSet = new HashSet(map.values());
        map2Set();

        //List<Map.Entry<Integer,String>> eList = new ArrayList<>(map.entrySet());
        //List keyList = new ArrayList(map.keySet());
        //List valList = new ArrayList(map.values());
        map2List();

        Integer[] iArray = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> iList = new ArrayList<>(Arrays.asList(iArray));
        //System.out.println("JOIN:\n"+join(iList,",",-1));

        String[] sArray = new String[]{"BJ", "SH", "GZ", "XM", "SZ"};
        List<String> sList = new ArrayList<>(Arrays.asList(sArray));
        //System.out.println("JOIN:\n"+join(sList,",",2));
        System.out.println("List JOIN:\n" + join(sList, ",", 3));

    }

    /**
     * 数组转List
     */
    public static void array2List() {
        //要想数组转化为List类，必须将int先转化为包装类Integer
        Integer[] iArray = new Integer[]{1, 2, 3, 4, 5};
        //若是包装类型的数组则可以直接转化
        /*for(int i = 0;i < iArray.length;++i) {
            iArray[i] = (Integer)iArray[i];
        }*/
        //接下来使用Arrays.asList()进行转换
        List<Integer> list = new ArrayList<>(Arrays.asList(iArray));
        System.out.println("数组转List：" + list);
        //这两种方法都可以
        list = Arrays.asList(iArray);
        System.out.println("数组转List：" + list);
    }

    /**
     * List转数组
     */
    public static void list2Array() {
        List<Integer> iList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            iList.add(i);
        }
        //方法1，先转Object数组，再遍历拷贝
        /*Object[] oArray =  iList.toArray();
        Integer[] iArray = new Integer[oArray.length];
        for(int i=0;i<oArray.length;i++){
            iArray[i] = (Integer)oArray[i];
        }*/

        //方法二，直接拷贝到指定类型数组
        Integer[] iArray = new Integer[iList.size()];
        iList.toArray(iArray);

        System.out.println("List转数组:");
        for (Integer i : iArray) {
            System.out.println(iArray[i] + " ");
        }
    }

    /**
     * array转Set
     */
    public static void array2Set() {
        Integer[] iArray = new Integer[]{1, 2, 3, 4, 5, 5, 5, 6, 7, 8};
        Set set = new HashSet(Arrays.asList(iArray));
        System.out.println("数组转Set：");
        System.out.println(set);
    }

    /**
     * set转Array
     */
    public static void set2Array() {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < 5; i++) {
            set.add(Integer.valueOf(i));
        }
        Integer[] iArray = new Integer[set.size()];
        set.toArray(iArray);
        System.out.println("Set 转数组：");
        for (Integer i : iArray) {
            System.out.println(i + " ");
        }
    }

    /**
     * List 转 set，直接通过构造函数
     */
    public static void list2Set() {
        List<Integer> iList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            iList.add(i);
        }
        iList.add(3);
        iList.add(5);
        iList.add(3);
        System.out.println("list转set前: " + iList);

        Set set = new HashSet(iList);
        System.out.println(("list转set后: " + set));
    }

    /**
     * set 转 list
     */
    public static void set2List() {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < 5; i++) {
            set.add(i);
        }
        List<Integer> iList = new ArrayList<>(set);
        System.out.println(("set转list: " + iList));
    }

    /**
     * map转set
     */
    public static void map2Set() {
        Map<Integer, String> map = new HashMap();
        map.put(1, "Beijing");
        map.put(2, "Shanghai");
        map.put(3, "Guangzhou");
        map.put(4, "Shenzhen");

        Set<Map.Entry<Integer, String>> eSet = map.entrySet();
        for (Map.Entry<Integer, String> e : eSet) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
        Set keySet = new HashSet(map.keySet());
        Set valSet = new HashSet(map.values());
        System.out.println(keySet + ":" + valSet);
    }

    /**
     * map转list
     */
    public static void map2List() {
        Map<Integer, String> map = new HashMap();
        map.put(1, "Beijing");
        map.put(2, "Shanghai");
        map.put(3, "Guangzhou");
        map.put(4, "Shenzhen");
        List<Map.Entry<Integer, String>> eList = new ArrayList<>(map.entrySet());
        for (Map.Entry<Integer, String> e : eList) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }

        List keyList = new ArrayList(map.keySet());
        List valList = new ArrayList(map.values());
        System.out.println(keyList + ":" + valList);
    }

    /**
     * 串接指定元素个数，返回连接字符串。
     *
     * @param list      要串接的元素List
     * @param separator 分隔字符串
     * @param length    串接的元素个数，小于0 则取0，大于List的size则取List的size
     * @param <T>       任意对象，串接对象的toString()方法返回的内容
     * @return 串接的元素字符串，最长不超过与集合的size
     */
    public static <T> String join(List<T> list, String separator, int length) {
        if (null == list || list.size() == 0 || length <= 0) {
            return "";
        }
        int size = list.size();
        length = length > size ? size : length;
        StringBuffer buffer = new StringBuffer();
        buffer.append(list.get(0));
        for (int i = 1; i < length; i++) {
            buffer.append(separator).append(list.get(i));
        }
        return buffer.toString();
    }


}
