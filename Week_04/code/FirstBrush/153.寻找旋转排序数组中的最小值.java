/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    /**
     * 二分查找法 1、目标函数单调性（单调递增或者递减） 2、存在上下界（bounded） 3、能够通过索引访问（index accessible）
     * 
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];

    }
}

// class Solution {
// public int findMin1(int[] nums) {
// if(nums.length==1){
// return nums[0];
// }
// int left=0,right=nums.length-1;
// if(nums[left]<nums[right]){
// return nums[left];
// }
// while(left<=right){
// int mid = left+(right-left)/2;
// if(nums[mid]>nums[mid+1]){
// return nums[mid+1];
// }
// if(nums[mid]<nums[mid-1]){
// return nums[mid];
// }
// if(nums[mid]>nums[0]){
// left = mid+1;
// }else{
// right = mid-1;
// }
// }
// return -1;
// }
// }
// @lc code=end
