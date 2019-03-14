package com.labs.common.util;

import java.util.*;

/**
 * 字符串格式化工具，包含功能：
 * *字符串连接 join
 *
 * @author tanyun.zheng
 * @version v1.0 2019/3/14 14:06
 */
public class StringFormatUtils {

    /**
     * 串接指定元素个数，返回连接字符串。
     *
     * @param collection 要串接的元素集合
     * @param separator 分隔字符串
     * @param length 串接的元素个数，小于0 则取0，大于集合的size则取集合的size
     * @param <T> 任意对象，串接对象的toString()方法返回的内容
     * @return 串接的元素字符串，最长不超过与集合的size
     */
    public static <T> String join(Collection<T> collection, String separator, int length){
        if (null==collection ||  collection.size()==0 || length <= 0)  {
            return "";
        }
        int size = collection.size();
        length = length > size ? size : length;
        StringBuffer buffer=new StringBuffer();
        Iterator it = collection.iterator();
        buffer.append(it.next());
        while(it.hasNext() && (--length)>0){
            buffer.append(separator).append(it.next());
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String[] sArray = new String[]{"BJ","SH","GZ","XM","SZ"};
        Set<String> sSet = new HashSet<>(Arrays.asList(sArray));
        System.out.println("Set JOIN:\n"+join(sSet,",",5));
        System.out.println("Set JOIN:\n"+"'"+join(sSet,"','",5)+"'");
    }
}
