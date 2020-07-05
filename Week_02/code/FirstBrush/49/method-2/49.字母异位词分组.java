import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 * 1、排序数组分类
 * 2、按计数分类
 */

// @lc code=start
class Solution {
    private static final int LITTLE_LETTER_COUNT = 26;

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>(strs.length);
        int[] count = new int[26];
        for (String s : strs) {
            //数组重新恢复为0
            Arrays.fill(count, 0);
            //遍历计数
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            //遍历拼接出键
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < LITTLE_LETTER_COUNT; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            //添加键的值（数组）
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        //返回最终的数据格式
        return new ArrayList<>(map.values());
    }
}
// @lc code=end
