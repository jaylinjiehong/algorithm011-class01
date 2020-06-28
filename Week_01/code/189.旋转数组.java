/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 * 
 * 题目分析：1、一个数组
 *          2、元素向右移动k个元素
 *          3、k是非负数
 *          4、找出3种解法
 *          5、空间复杂度为O(1)
 * 解法： 使用环状替换
 * 
 */

// @lc code=start
 class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
// @lc code=end

