/*
 * @lc app=leetcode.cn id=1025 lang=java
 *
 * [1025] 除数博弈
 */

// @lc code=start
class Solution {
    /**
     * 边界值法
     * 
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        if (N <= 0) {
            return false;
        }
        if (N % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end
