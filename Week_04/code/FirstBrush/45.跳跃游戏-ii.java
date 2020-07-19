/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    /**
     * 假设你总是可以到达数组的最后一个位置。
     * 正向查找可到达的最大位置
     * 我们维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，
     * 更新边界并将跳跃次数增加1
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int length =nums.length;
        int end =0;
        int maxPosition =0;
        int steps =0;
        for(int i=0;i<length-1;i++){
            maxPosition = Math.max(maxPosition, i+nums[i]);
            if(i==end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
// @lc code=end

