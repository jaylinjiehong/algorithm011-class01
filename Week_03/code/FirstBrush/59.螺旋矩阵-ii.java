/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    /**
     * 模拟法，设定边界。
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int l =0,r=n-1,t=0,b=n-1;
        int[][] mat = new int[n][n];
        int num =1,tar = n*n;
        while(num<=tar){
            for(int i=l;i<=r;i++){
                mat[t][i]=num++;
            }
            t++;//边界更新
            for(int i=t;i<=b;i++){
                mat[i][r]=num++;
            }
            r--;//边界更新
            for(int i=r;i>=l;i--){
                mat[b][i]=num++;
            }
            b--;//边界更新
            for(int i=b;i>=t;i--){
                mat[i][l]=num++;
            }
            l++;//边界更新
        }
        return mat;

    }
}
// @lc code=end

