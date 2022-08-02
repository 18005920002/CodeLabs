package com.labs.datastruct;

import com.labs.algs4lib.StdIn;
import com.labs.algs4lib.StdOut;

import java.util.Arrays;


/**
 * @Description: 二分查找
 * @Author: tanyun.zheng
 * @Date: 2019/11/16 11:03
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        int low = 0;
        int height = a.length - 1;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (key < a[mid]) {
                height = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        /**
         * 先对无序数组序列进行排序，然后进行二分查找
         *  - 找到返回索引
         *  - 找不到返回-1
         */
        int[] whiteList = {11, 99, 32, 57, 46, 83, 27, 15, 78, 30};
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int index = rank(key, whiteList);
            if (index == -1) {
                StdOut.println(key);
            } else {
                StdOut.println("Found @ " + index);
            }
        }
    }
}
