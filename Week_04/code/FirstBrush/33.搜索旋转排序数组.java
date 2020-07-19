/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    /**
     * 二分查找法:当找不到target时while的每次操作目的是-找到下一个二分查找的子数组
     * 每次比较nums[mid]和nums[0]的大小关系在旋转排序数组里面很关键，可以找到一定有序的子数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left =0,right=nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            //这里必须为<=而不是<的原因是什么？
            if(nums[0]<=nums[mid]){
                if(nums[left]<=target&&nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

