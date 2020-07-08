/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    /**
     * 双指针法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i =0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                if(i!=j){
                    nums[i]=nums[j];
                    nums[j]=0;
                }
                i++; 
            }
        }

    }
}
// @lc code=end

