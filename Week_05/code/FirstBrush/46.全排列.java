import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    /**
     * DFS遍历+回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(length==0){
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(nums,length,0,path,used,result);
        return result;
    }

    private void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if(depth==length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i =0;i<length;i++){
            if(used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,length,depth+1,path,used,result);
            path.removeLast();
            used[i]=false;
        }
    }
}
// @lc code=end

