import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    private Map<Integer,Integer> dict = new HashMap<>();
    /**
     * 递归求解
     * 1、递归终止条件
     * 2、处理本层逻辑
     * 3、下探到下一层
     * 4、清理本层状态
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(dict.containsKey(n)){
            return dict.get(n);
        }
        int result = climbStairs(n-1)+climbStairs(n-2);
        dict.put(n, result);
        return result;
    }
}
// @lc code=end

