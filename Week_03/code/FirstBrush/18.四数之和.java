import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 * 
 */
/**
 * 方法2：递归！
 */

// @lc code=start
class Solution {
    /**
     * 方法1：迭代-大问题分解成小问题太奇妙了 O(n^3)时间复杂度、O(1)空间复杂度
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4) {
            return res;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 最大元素
        int max = nums[len - 1];
        // 把所有边界给排除掉
        if (4 * nums[0] > target || 4 * max < target) {
            return res;
        }

        //
        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            // 避免相同的值
            if (i > 0 && z == nums[i - 1]) {
                continue;
            }
            // z值是太小了
            if (z + 3 * max < target) {
                continue;
            }
            // z是太大了
            if (4 * z > target) {
                break;
            }
            if (4 * z == target) {
                if (i + 3 < len && nums[i + 3] == z) {
                    res.add(Arrays.asList(z, z, z, z));
                }
                break;
            }

            // 前面的判断条件很巧妙，把所有情况都考虑了。
            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);

        }
        return res;
    }

    /*
     * Find all possible distinguished three numbers adding up to the target in
     * sorted array nums[] between indices low and high. If there are, add all of
     * them into the ArrayList fourSumList, using fourSumList.add(Arrays.asList(z1,
     * the three numbers)) 找剩下的三个数
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
            int z1) {
        if (low + 1 >= high) {
            return;
        }
        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target) {
            return;
        }

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) {
                continue;
            }
            if (z + 2 * max < target) {
                continue;
            }
            if (3 * z > target) {
                break;
            }
            if (3 * z == target) {
                if (i + 1 < high && nums[i + 2] == z) {
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                }
                break;
            }
            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }
    }

    /*
     * Find all possible distinguished two numbers adding up to the target in sorted
     * array nums[] between indices low and high. If there are, add all of them into
     * the ArrayList fourSumList, using fourSumList.add(Arrays.asList(z1, z2, the
     * two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
            int z1, int z2) {
        if (low >= high) {
            return;
        }
        if (2 * nums[low] > target || 2 * nums[high] < target) {
            return;
        }
        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));
                x = nums[i];
                // avoid duplicate
                while (++i < j && x == nums[i]){
                } 
                x = nums[j];
                // avoid duplicate
                while (i < --j && x == nums[j]){
                }
            }
            if (sum < target){
                i++;
            }  
            if (sum > target){
                j--;
            }   
        }
        return;
    }

}
// @lc code=end
