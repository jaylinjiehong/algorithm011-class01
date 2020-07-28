import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    /**
     * 动态规划：自下而上
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}

// class Solution {
// /**
// * 动态规划：自上而下
// */
// public int coinChange(int[] coins, int amount) {
// if(amount<1){
// return 0;
// }
// return coinChange(coins, amount,new int[amount]);

// }

// private int coinChange(int[] coins, int rem, int[] count) {
// if(rem<0){
// return -1;
// }
// if(rem == 0){
// return 0;
// }
// if(count[rem-1]!=0){
// return count[rem-1];
// }
// int min = Integer.MAX_VALUE;
// for(int coin:coins){
// int res = coinChange(coins, rem-coin, count);
// if(res>=0&&res<min){
// min = 1+res;
// }
// }
// count[rem-1] = (min==Integer.MAX_VALUE)?-1:min;
// return count[rem-1];
// }
// }
// @lc code=end
