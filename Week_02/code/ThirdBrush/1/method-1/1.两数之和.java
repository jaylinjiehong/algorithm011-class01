/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 1、暴力法
 * 2、两遍哈希列表
 * 3、一便哈希列表
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int addend = target - nums[i];
                if (addend == nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("no two addend is suitable");
    }
}
// @lc code=end
