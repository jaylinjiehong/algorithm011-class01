/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 * 题目分析：1、排序数组
 *          2、原地删除重复元素
 *          3、返回数组新长度
 *          4、O(1)额外空间
 * 解法：快慢指针
 * 优化：减少不必要的操作：快慢指针是邻居时，不复制。
 */

// @lc code=start
class Solution {
    private static final int BOUNDARY_VALUE = 2;
    public int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }

        int length = nums.length;
        if(length<BOUNDARY_VALUE){
            return length;
        }

        int slowPointer = 0;
        int quickPointer = 1;

        for( ; quickPointer < length; quickPointer++){
            if(nums[slowPointer] != nums[quickPointer]){
                if(quickPointer - slowPointer++ > 1){
                    nums[slowPointer] = nums[quickPointer];
                }
            }
        }

        return slowPointer+1;
    }
}
// @lc code=end

