/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
// class Solution {
//     /**
//      * 递归解法
//      */
//     public ListNode reverseList(ListNode head) {
//         // 1、递归终止条件
//         if(head==null||head.next==null){
//             return head;
//         }
//         // 2、本层处理逻辑
//         // 3、进入下一层
//         ListNode cur = reverseList(head.next);
//         // 4、清理本层状态
//         head.next.next = head;
//         head.next = null;
//         return cur;
//     }
// }


class Solution {
    /**
     * 迭代解法
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}


// @lc code=end

