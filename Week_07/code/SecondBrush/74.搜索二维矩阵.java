/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    /**
     * 转化为二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0){
            return false;
        }
        int col = matrix[0].length;
        int left =0,right = row*col-1,mid =0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(matrix[mid/col][mid%col]==target){
                return true;
            }
            if(matrix[mid/col][mid%col]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;

    }
}
// @lc code=end

