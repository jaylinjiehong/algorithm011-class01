/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    /**
     * 贪心思想：实时维护最远可以到达的距离
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightMost = 0;
        for(int i=0;i<length;i++){
            if(i<=rightMost){
                rightMost = Math.max(rightMost, i+nums[i]);
                if(rightMost>=length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

