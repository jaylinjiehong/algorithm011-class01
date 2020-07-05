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
/**
 * 1、排序数组分类：有序的字母异位词是相同的。
 * 作为键很方便查找，键的生成采用char数组的排序算法
 *
 * 2、按计数分类：有序的字母异位词是相同的。
 * 作为键很方便查找，键的生成采用计数的方式进行。
 */
// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        //哈希表来保存
        Map<String, List<String>> ans = new HashMap<>(strs.length);
        for (String s : strs) {
            //转化为char数组进行排序
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            //转化为字符串作为Map的键保存
            String key = String.valueOf(ca);
            //没有键，就创建一个
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        //返回最终需要的数组类型。
        return new ArrayList<>(ans.values());

    }
}
// @lc code=end
