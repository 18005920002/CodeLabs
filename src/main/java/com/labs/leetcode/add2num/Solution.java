package com.labs.leetcode.add2num;//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


//leetcode submit region begin(Prohibit modification and deletion)

import lombok.val;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        //n1.next = new ListNode(4);
        //n1.next.next = new ListNode(5);
        //n1.next.next.next = new ListNode(6);

        ListNode n2 = new ListNode(9);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(9);
        //n2.next.next.next = new ListNode(9);

        ListNode n3 = new Solution().addTwoNumbers(n1, n2);
        System.out.println(n3.val
                + "->" + n3.next.val
                + "->" + n3.next.next.val
                + "->" + n3.next.next.next.val);
    }

    /**
     * 哑节点
     * @param l1
     * @param l2
     * @return
     */
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }*/

    /**
     * 初始化首节点
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始化首节点
        int bitSum = l1.val + l2.val;
        ListNode head = new ListNode(bitSum % 10);
        ListNode current = head;
        //是否进位
        int carry = bitSum / 10;
        //往后遍历直到某个链表先结束
        ListNode currA = l1.next;
        ListNode currB = l2.next;

        while (null != currA || null != currB) {
            int va = null == currA ? 0 : currA.val;
            int vb = null == currB ? 0 : currB.val;
            int newVal = (va + vb + carry);
            current.next = new ListNode(newVal % 10);
            carry = newVal / 10;

            if (null != currA) {
                currA = currA.next;
            }
            if (null != currB) {
                currB = currB.next;
            }
            current = current.next;
        }

        //检查是否溢出
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        return head;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
