/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    /**
     * 分析边界9999
     * 
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i]=0;
                count++;
            }
        }
        int[] result = new int[count + 1];
        result[0] = 1;
        return result;
    }
}
// @lc code=end
