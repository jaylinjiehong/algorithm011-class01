import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
  
    /**
     * 动态规划-自上而下
     * 如同爬楼梯问题，每次步长为coins的每个值，假设最后一步为n，则f(n)=f(n-1)+1
     * 【这里的步数1代表的步长可以为conis的每个值】
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // 判断边界值
        if(amount<1){
            return 0;
        }
        //求f(n)
        return coinChange(coins, amount, new int[amount]);
      
    }
    private int coinChange(int[] coins, int rem, int[] count) {
        //1、剩余步长小于0，需要走-1步（回退1步）
        if(rem<0){
            return -1;
        }
        //2、剩余步长为0，返回走0步
        if(rem==0){
            return 0;
        }
        //3、判断历史记忆是否已经存了剩余步长为rem的最小步数。
        if(count[rem-1]!=0){
            return count[rem-1];
        }
        //4、求出上一步的每种步长，之前走过的步数最小值
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            //5、求f(n-1)
            int res = coinChange(coins, rem-coin, count);
            if(res>=0&&res<min){
                min = 1+res;
            }
        }
        //6、记录最小步数
        count[rem-1] = (min==Integer.MAX_VALUE)? -1:min;
        // 7、返回最小步数历史记录表
        return count[rem-1];
    }
}
// @lc code=end

