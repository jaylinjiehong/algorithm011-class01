/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    /**
     * 求最长公共子序列的算法分析：
     * 1、具有最优子结构
     * 2、c[][j]记录序列Xi和Yj的最长公共子序列的长度
     * 2.1、当i=0,j=0;c[i][j]=0
     * 2.2、当i,j>0;Xi = Yj; c[i-1][j-1]+1
     * 2.3、当i,j>0;Xi!=Yj; c[i][j] = max{c[i-1][j],c[i][j-1]}
     * 【备注：这里的i与j为0代表0个元素，而不是下标】
     * 
     * 3、在计算c[i][j]的同时，用b[i][j]记录该值由哪种方式产生，也分三种情况
     * 3.1、c[i][j] = c[i-1][j-1]+1; b[i][j] =1
     * 3.2、 c[i][j] = c[i-1][j]; b[i][j] = 2
     * 3.3、 c[i][j] = c[i][j-1]; b[i][j] = 3
     * 
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int text1Length = text1.length();
        int text2Length = text2.length();
        int dp[][] = new int[text1Length+1][text2Length+1];
        for(int x =0;x<text1Length;x++){
            for(int y =0;y<text2Length;y++){
                if(text1.charAt(x)==text2.charAt(y)){
                    // 由于只要i=0或者j=0,代表某个序列的元素值为0，因此dp[1][1]才是每个序列第一个元素的结果，就是x=0,y=0
                    dp[x+1][y+1] = dp[x][y]+1;
                }else{
                    dp[x+1][y+1] = Math.max(dp[x+1][y], dp[x][y+1]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }
}
// @lc code=end

