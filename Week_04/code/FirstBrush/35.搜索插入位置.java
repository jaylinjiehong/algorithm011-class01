import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    /**
     * 二分查找法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left =0,right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left =mid+1;
            }else {
                right = mid -1;
            }
        }
        return left;
    }
}
// @lc code=end

