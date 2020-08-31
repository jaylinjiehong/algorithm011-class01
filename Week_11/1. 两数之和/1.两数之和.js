/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * 一遍哈希表法
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const map = {};
    for (let i = 0; i < nums.length; i++) {
        const another = target - nums[i];
        if (another in map) {
            return [map[another], i];
        }
        map[nums[i]] = i;
    }
    return null;
};

// @lc code=end