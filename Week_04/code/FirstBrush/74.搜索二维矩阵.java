/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    /**
     * 二分查找法：把二维数组给拉成一维数组
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0){
            return false;
        }
        int n =matrix[0].length;

        int left =0,right = m*n-1;
        while(left<=right){
            int mid = (left+right)/2;
            int origalValue = matrix[mid/n][mid%n];
            if(origalValue==target){
                return true;
            }else{
                if(origalValue<target){
                    left = mid+1;
                }else{
                    right=mid-1;
                }

            }
        }
        return false;
    }
}
// @lc code=end

