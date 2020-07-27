/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    /**
     * 动态规划
     * 时间复杂度：O(m×∣Σ∣+n)
     * 空间复杂度：O(m×∣Σ∣)
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;

    }
}
// class Solution {
// /**
// * 双指针：贪心算法
// * 时间复杂度：O(n+m)
// * 空间复杂度：O(1)
// * @param s
// * @param t
// * @return
// */
// public boolean isSubsequence(String s, String t) {
// int n = s.length(),m=t.length();
// int i=0,j=0;
// while(i<n&&j<m){
// if(s.charAt(i)==t.charAt(j)){
// i++;
// }
// j++;
// }
// return i==n;
// }
// }
// @lc code=end
