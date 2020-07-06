import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    /**
     * 方法1：排序数组分类法 解法：先把单词排序，然后把排序后的词作为hash的key值，然后value存相同异位词的数组 最后，输出正确的格式。
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> dict = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String tempStr = String.valueOf(temp);
            if (!dict.containsKey(tempStr)) {
                dict.put(tempStr, new ArrayList<>());
            }
            dict.get(tempStr).add(s);
        }
        // 返回正确的数据格式
        return new ArrayList<>(dict.values());
    }

    /**
     * 方法2：按计数数组分类法 通过字母的性质，进行计数法形成唯一的key，作为一个标识，value还是存数组
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        int[] littleLetters = new int[26];
        Map<String, List<String>> dict = new HashMap<>(strs.length);
        for (String s : strs) {
            Arrays.fill(littleLetters, 0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                littleLetters[s.charAt(i) - 'a']++;
            }
            for (int i : littleLetters) {
                sb.append(i);
            }
            if (!dict.containsKey(sb.toString())) {
                dict.put(sb.toString(), new ArrayList<>());
            }
            dict.get(sb.toString()).add(s);
        }
        return new ArrayList<>(dict.values());
    }
}
// @lc code=end
