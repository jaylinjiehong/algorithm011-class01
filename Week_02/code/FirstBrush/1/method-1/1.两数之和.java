/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 暴力法
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int addend;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                addend = target - nums[i];
                if (addend == nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two addend is suitable ");
    }
}
// @lc code=end
