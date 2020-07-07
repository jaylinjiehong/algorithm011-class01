
/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    /**
     * 一次遍历法：双指针记录法 数字的大小规律：存在列表中的每个数位，左边的值越大，代表数字越大。
     * 因此寻找是否存在下个更大的数，就是找从右到左，是否存在相邻的数位满足条件， 若不满足，则反转数位。 若满足，则此时最左边的指针就是不规则数位
     * 就寻找从右往左第一个大于不规则数位的数位，然后两者进行换位置。 可以把反转和换位置抽离为单独的函数。
     * 
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 循环只做移动指针的活
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 循环只做移动指针的活
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * 从某个位置开始反转数组
     */
    private void reverse(int[] nums, int start) {
        int i = nums.length - 1;
        while (i > start) {
            swap(nums, i, start);
            i--;
            start++;
        }
    }

    /**
     * 换位置
     * 
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
