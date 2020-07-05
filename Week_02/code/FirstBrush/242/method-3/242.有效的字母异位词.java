/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 * 1、排序
 * 2、哈希表
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        int[] tables = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tables[s.charAt(i) - 'a']++;
            tables[t.charAt(i) - 'a']--;
        }
        for (int temp : tables) {
            if (temp != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
