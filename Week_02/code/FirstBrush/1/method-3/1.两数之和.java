import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 一遍哈希表
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> rulesMap = new HashMap<>(nums.length);
        for(int i = 0 ; i < nums.length; i++){
            int tempInt = target - nums[i];
            if(rulesMap.containsKey(tempInt)){
                return new int[]{rulesMap.get(tempInt),i};
            }
            rulesMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two addend is suitable");
    }
}
// @lc code=end

