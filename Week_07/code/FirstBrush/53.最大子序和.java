/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    /**
     * 动态规划
     * 正数增益
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum =0;
        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else{
                sum =num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}


// class Solution {
//     /**
//      * 动态规划
//      */
//     public int maxSubArray(int[] nums) {
//         int ans = nums[0];
//         int sum =0;
//         for(int num:nums){
//             if(sum>0){
//                 sum+=num;
//             }else{
//                 sum =num;
//             }
//             ans = Math.max(ans, sum);
//         }
//         return ans;
//     }
// }


// class Solution {
//     /**
//      * 1、暴力法
//      */
//     public int maxSubArray(int[] nums) {
//         int length = nums.length;
//         if(length==0){
//             return 0;
//         }
//         int max =Integer.MIN_VALUE;
//         for(int i=0;i<length;i++){
//             int temp = nums[i];
//             max = Math.max(max, temp);
//             for(int j =i+1;j<length;j++){
//                 temp +=nums[j];
//                 max = Math.max(max, temp);
//             }
//         }
//         return max; 
//     }
// }
// @lc code=end

