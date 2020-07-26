import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    /**
     * 由两数之和和三数之和推导而来 排序+双指针
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);

        int length = nums.length;

        for (int k = 0; k < length - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            if ((nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3]) > target) {
                break;
            }
            if ((nums[k] + nums[length - 3] + nums[length - 2] + nums[length - 1]) < target) {
                continue;
            }
            for (int i = k + 1; i < length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int h = length - 1;
                if ((nums[k] + nums[i] + nums[j] + nums[j + 1]) > target) {
                    continue;
                }
                if ((nums[k] + nums[i] + nums[h - 1] + nums[h]) < target) {
                    continue;
                }
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }

        }
        return result;
    }
}
// @lc code=end
