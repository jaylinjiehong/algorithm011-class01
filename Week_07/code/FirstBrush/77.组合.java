import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    /**
     * 剪枝
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
      if(n<=0||k<=0||n<k){
          return res;
      }
      findCombinations(n,k,1,new Stack<>());
      return res;
    }

    private void findCombinations(int n, int k, int index, Stack<Integer> p) {
        if(p.size()==k){
            res.add(new ArrayList<>(p));
            return;
        }
        for(int i=index;i<=n-(k-p.size())+1;i++){
            p.push(i);
            findCombinations(n, k, i+1, p);
            p.pop();
        }
    }

}


// class Solution {
//     private List<List<Integer>> res = new ArrayList<>();
//     /**
//      * 回溯
//      * @param n
//      * @param k
//      * @return
//      */
//     public List<List<Integer>> combine(int n, int k) {
//         if(n<=0||k<=0||n<k){
//             return res;
//         }
//         findCombinations(n,k,1,new Stack<>());
//         return res;
//     }

//     private void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
//        if(pre.size()==k){
//            res.add(new ArrayList<>(pre));
//            return;
//        } 
//        for(int i=begin;i<=n;i++){
//            pre.add(i);
//            findCombinations(n, k, i+1, pre);
//            pre.pop();
//        }
//     }
// }
// @lc code=end

