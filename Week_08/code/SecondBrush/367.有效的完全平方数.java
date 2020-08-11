/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
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

