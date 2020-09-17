import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=685 lang=java
 *
 * [685] 冗余连接 II
 */

// @lc code=start
class Solution {
    /**
     * 数组保存边的关系，定义【1,2】 1：出头；2、入头。 保存入头的历史 保存出头的历史 例1：入头：2、3、3 出头：1、2
     * 当下一轮【2,3】发现：本该出头却已经在入头，而且入头的已经在历史记录里了，jank！
     * 例2：入头：2、3、4、1、出头：1、2、3、4当下一轮【4,1】发现本该出头的却已经在入头，而且入头的已经在历史记录里了，jank！
     * 
     * 例3：入头：1、1、2、4出头：2、3、4、1 * dfs遍历：把已经遍历的节点保存，遇到保存的
     * 
     * 
     * 1、每个只有一个父节点，除了根节点没有父节点； 2、
     * 
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Set<Integer> AllList = new HashSet<>();
        Set<Integer> inList = new HashSet<>();
        int[] res = new int[2];
        // int length = edges.length;
        for (int[] edge : edges) {
            if (inList.contains(edge[0]) && AllList.contains(edge[1])) {
                res = edge;
                break;
            }
            inList.add(edge[1]);
            AllList.add(edge[0]);
            AllList.add(edge[1]);
        }
        return res;

    }
}
// @lc code=end
