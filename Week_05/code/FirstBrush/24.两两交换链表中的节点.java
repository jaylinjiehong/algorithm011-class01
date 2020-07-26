import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
//      * @param head
//      * @return
//      */
//     public ListNode swapPairs(ListNode head) {
//         if(head==null||head.next==null){
//             return head;
//         }
//         ListNode firstNode = head;
//         ListNode secondNode = head.next; 

//         firstNode.next = swapPairs(secondNode.next);
//         secondNode.next = firstNode;
//         return secondNode;     
//     }
// }

class Solution {
    /**
     * 迭代解法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
         ListNode  dummy = new ListNode(-1);
         dummy.next = head;

         ListNode prevNode = dummy;
         while(head!=null&&head.next!=null){
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
         }
         return dummy.next;
    }
}
// @lc code=end

