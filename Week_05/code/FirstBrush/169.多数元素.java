import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    /**
     * Boyer-Moore 投票算法
     * 由于多数元素总是大于数组元素的一半，因此此算法会过滤出多数元素！
     * 多数元素的性质决定数组有且只有一个多数元素
     * 
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
// @lc code=end
