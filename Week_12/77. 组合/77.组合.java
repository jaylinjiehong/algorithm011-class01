/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    /**
     * dfs
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0||n<k){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }
    private void dfs(int n,int k,int index,Deque<Integer> path,List<List<Integer>> res){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        // 这里的i<n-(k-path.size())+1目的就是剪枝。
        // 这里的path.removeLast()就是回溯。
        for(int i=index;i<=n-(k-path.size())+1;i++){
            path.addLast(i);
            dfs(n,k,i+1,path,res);
            path.removeLast();
        }
    }
}
// @lc code=end

