import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * Floyd算法:快慢指针
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode intersect = getIntersect(head);
        if(intersect==null){
            return null;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while(ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while(hare!=null&&hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;

            if(tortoise == hare){
                return tortoise;
            }
        }
        return null;
    }
}
// @lc code=end

