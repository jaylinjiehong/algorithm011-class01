import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 递归解法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode cur = head;
       int count = 0;
       while(cur!=null&&count!=k){
           cur =cur.next;
           count++;
       }
       if(count ==k){
           cur = reverseKGroup(cur, k);
           while(count!=0){
               count--;
               ListNode tmp = head.next;
               head.next = cur;
               cur = head;
               head = tmp;
           }
           head = cur;
       }
       return head;
    }
}
// @lc code=end

