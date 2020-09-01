/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */

// @lc code=start
class Solution {
    /**
     * 方法1、先排序后递归
     * 方法2、动态规划？
     */
    public boolean PredictTheWinner(int[] nums) {
        // 递归，算总分，正手得分为正，反手得分为负，每轮从数组两端找最大值。（每个玩家都会找最大值）
        return total(nums,0,nums.length-1,1)>=0;
    }
    private int total(int[] nums,int start,int end,int turn){
        // 1、递归终止条件
        if(start == end){
            return nums[start]*turn;
        }
        // 2、处理本层逻辑：每次总是找总分的最大值 3、下探到下一层
        int scoreStart = nums[start]*turn + total(nums,start+1,end,-turn);
        int scoreEnd = nums[end]*turn+total(nums,start,end-1,-turn);
        // 4、保存本层状态：找出本轮最大值的（之所以会乘以turn，是为了让反手时也选择分数最大的）
        return Math.max(scoreStart*turn,scoreEnd*turn)*turn;
    }
}
// @lc code=end

