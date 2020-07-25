/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    /**
     * 在原字符串上直接判断+双指针
     * 时间复杂度：O(|s|) |s|是字符串s的长度
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left =0,right = n-1;
        while(left<right){
            while(left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                ++left;
            }
            while(left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                --right;
            }
            if(left<right){
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
// @lc code=end

