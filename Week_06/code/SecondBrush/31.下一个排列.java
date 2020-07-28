/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    /**
     * 一遍哈希法：找到下一个交换的位置，例如： [3,4,5,2]->[3,5,2,4]
     * 步骤1:从右往左找：第一次出现【左边的数】小于【右边的数】的位置。
     * 步骤2：从最右往左找，找第一个大于【左边的数】的数，然后交换位置（特殊情况是nums[0]和自身交换）。
     * 步骤3：从【左边的数】的右边第一个数到数组结尾，进行从小到大排序（由于本来是从大到小排序的，因此进行倒序操作）
     */
    public void nextPermutation(int[] nums) {
        int i= nums.length-2;
        while(i>=0&&nums[i+1]<=nums[i]){
            i--;
        }
        if(i>=0){
            int j = nums.length -1;
            while(j>0&&nums[j]<=nums[i]){
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int k = nums.length-1;
        i=i+1;
        while(i<k){
            int temp = nums[i];
            nums[i]=nums[k];
            nums[k] =temp;
            i++;
            k--;
        }
    }
    

}
// @lc code=end

