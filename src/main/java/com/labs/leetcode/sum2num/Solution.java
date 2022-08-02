package com.labs.leetcode.sum2num;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int[] twoSum(int[] nums, int target) {
        int[] re={0,0};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    re[0] = i;
                    re[1] = j;
                }
            }
        }
        return re;
    }*/

    /**
     * 两遍Hash
     * @param nums
     * @param target
     * @return
     */
    /*public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/

    /**
     * 一遍Hash
     *
     * @param nums
     * @param target
     * @return
     */
    /*public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/
    public int[] twoSum(int[] nums, int target) {
        Map numMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        int cmp = 0;
        for (int i = 0; i < nums.length; i++) {
            cmp = target - nums[i];
            if (numMap.containsKey(cmp) && (int) numMap.get(cmp) != i) {
                return new int[]{(int) numMap.get(cmp), i};
            }
        }
        throw new IllegalArgumentException("No Two Sum Solutions.");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 11};
        /*int[] re = new Solution().twoSum(nums,18);
        System.out.println(re[0]+":"+re[1]);
        */
        LocalDateTime t1 = LocalDate.now().atTime(0, 0, 0);
        LocalDateTime t2 = LocalDate.now().atTime(23, 59, 59);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(t1);
        System.out.println(t2);

        System.out.println(fmt.format(t1));
        System.out.println(fmt.format(t2));

        String json = "[]";
        try {

            List<Long> ids = JSON.parseArray(json, Long.class);

        } catch (JSONException e) {
            System.out.println("格式有误");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
