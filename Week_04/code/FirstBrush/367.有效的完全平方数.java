/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    /**
     * 二分查找法:
     * 这里的left=2和right=num/2很巧妙，目的是减少不必要的运算
     * 
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2, mid, temp;
        while (left <= right) {
            mid = left + (right - left) / 2;
            temp = mid * mid;
            if (temp == num) {
                return true;
            }
            if (temp > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }
}
// @lc code=end
