/*
 * @lc app=leetcode.cn id=1 lang=kotlin
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    /**
     * 一遍哈希表法
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int,Int> = mutableMapOf()
        for(i in nums.indices){
            val other: Int = target - nums[i]
            if(map.containsKey(other)){
                return intArrayOf(map[other]!!,i)
            }
            map[nums[i]] = i
        }
        throw IllegalArgumentException("No two sum solution")
    }
}
// @lc code=end

