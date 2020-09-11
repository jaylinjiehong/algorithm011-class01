/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    /***
     * 剪枝+回溯
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(k,1,0,n,stack,res);
        return res;
    }
    private void dfs(int k,int begin,int level,int n,Deque<Integer> stack,List<List<Integer>> res){
        //1、递归终止条件
        if(n==0&&level==k){
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i=begin;i<=n;i++){
            //2、剪枝
            if(level<k&&i<=n&&i<=9){
                //3回溯
               stack.addLast(i);
               dfs(k,i+1,level+1,n-i,stack,res);
               stack.removeLast();
            }
            
        }
    }
}
// @lc code=end

