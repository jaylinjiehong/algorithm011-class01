import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import sun.print.resources.serviceui;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    /**
     * 贪心解法
     * 排序后双指针：快慢指针
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if(g==null||s==null){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi =0,si=0;
        while(gi<g.length&&si<s.length){
            if(g[gi]<=s[si]){
                gi++;
            }
            si++;
        }
        return gi;

    }
}
// @lc code=end

