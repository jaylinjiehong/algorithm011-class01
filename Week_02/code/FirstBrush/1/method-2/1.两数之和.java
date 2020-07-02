import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 两遍哈希表
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> rulesMap  = new HashMap<>(nums.length);
        for(int i = 0; i<nums.length; i++){
            rulesMap.put(nums[i],i);
        }
        int tempInt;
        for(int i = 0; i < nums.length; i++){
            tempInt = target-nums[i];
            if(rulesMap.containsKey(tempInt) && rulesMap.get(tempInt)!=i){
                return new int[]{i,rulesMap.get(tempInt)};
            }
        }
        throw new IllegalArgumentException("no two addend is suitable");
    }
}
// @lc code=end

