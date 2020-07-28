/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    /**
     * 双指针法
     */
    public int removeDuplicates(int[] nums) {
        int i=0,j=1;
        for(;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }
}
// @lc code=end

