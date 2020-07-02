import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 1、暴力法
 * 2、两遍哈希列表
 * 3、一遍哈希列表
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> oneAddendMap = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            oneAddendMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int addend = target-nums[i];
            if(oneAddendMap.containsKey(addend) && oneAddendMap.get(addend)!=i){
                return new int[]{i,oneAddendMap.get(addend)};
            }
        }
        throw new IllegalArgumentException("no two addend is suitable");
        
    }
}
// @lc code=end

