import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    /**
     * dfs、剪枝
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
      int len = nums.length;
      List<List<Integer>> res = new ArrayList<>();
      if(len==0){
          return res;
      }

      Arrays.sort(nums);

      boolean[] used = new boolean[len];

      Deque<Integer> path = new ArrayDeque<>(len);
      dfs(nums,len,0,used,path,res);
      return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;++i){
            if(used[i]){
                continue;
            }

            // 剪枝
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums,len,depth+1,used,path,res);

            used[i]= false;
            path.removeLast();

        }
    }
}
// @lc code=end

