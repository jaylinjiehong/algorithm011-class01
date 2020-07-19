/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    /**
     * 1、袖珍计算器算法
     * 2、二分查找法
     * 3、牛顿迭代法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
      int left = 0,right=x,mid,result=0;
      while(left<=right){
          mid = left+(right-left)/2;
          if((long)mid*mid<=x){
              result=mid;
              left = mid+1;
          }else{
            right = mid-1;
          }
      }
      return result;
    }
}
// @lc code=end

