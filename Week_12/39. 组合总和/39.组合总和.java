/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        //栈
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,target, path,res);
        return res;
    }
    /**
     * 回溯+剪枝
     */
    private void dfs(int[] candidates,int begin,int target,Deque<Integer> path,List<List<Integer>> res){
       
        if(target==0){
            res.add(new ArrayList<>(path));
        }
        for(int i=begin;i<candidates.length;i++){
               // 剪枝
                if(target-candidates[i]<0){
                    break;
                }
                path.addLast(candidates[i]);
                dfs(candidates,i,target-candidates[i],path,res);
                // 回溯
                path.removeLast();
            
        }
    }
}
// @lc code=end

