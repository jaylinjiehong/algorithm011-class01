import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    /**
     * 动态规划
     * 无论状态转移方程多复杂，只要写的出来，这题目就解决了！
     * dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>(n);
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for(int i=1;i<=n;i++){
            List<String> cur = new ArrayList<>();
            for(int j =0;j<i;j++){
               List<String> str1 = dp.get(j);
               List<String> str2 = dp.get(i-1-j);
               for(String s1 : str1){
                   for(String s2 : str2){
                       cur.add("("+s1+")"+s2);
                   }
               }
            }
            dp.add(cur);
        }
       return dp.get(n);
    }
}




// class Solution {
//     class Node{
//         private String res;
//         private int left;
//         private int right;
//         public Node(String str,int left,int right){
//             this.res = str;
//             this.left = left;
//             this.right = right;
//         }
//     }
//     /**
//      * bfs
//      * 做加法
//      * @param n
//      * @return
//      */
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<>();
//         if(n==0){
//             return res;
//         }
//         Queue<Node> queue = new LinkedList<>();
//         queue.offer(new Node("",n,n));
//         while(!queue.isEmpty()){
//             Node curNode = queue.poll();
//             if(curNode.left==0&&curNode.right==0){
//                 res.add(curNode.res);
//             }
//             if(curNode.left>0){
//                 queue.offer(new Node(curNode.res+"(",curNode.left-1,curNode.right));
//             }
//             if(curNode.right>0&&curNode.left<curNode.right){
//                 queue.offer(new Node(curNode.res+")",curNode.left,curNode.right-1));
//             }
//         }
//         return res;
//     }
// }



// class Solution {
//     /**
//      * DFS：回溯+剪枝
//      * 做加法
//      * @param n
//      * @return
//      */
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<>();
//         if(n==0){
//             return res;
//         }
//         dfs("",0,0,n,res);
//         return res;
//     }

//     private void dfs(String curStr, int left, int right, int n, List<String> res) {
//         if(left==n&&right==n){
//             res.add(curStr);
//         }
//         if(left<right){
//             return;
//         }
//         if(left<n){
//             dfs(curStr+"(",left+1,right,n,res);
//         }
//         if(right<n){
//             dfs(curStr+")",left,right+1,n,res);
//         }
//     }
// }




// class Solution {
//     /**
//      * DFS：回溯+剪枝
//      * 做减法
//      * @param n
//      * @return
//      */
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<>();
//         if(n==0){
//             return res;
//         }
//         dfs("",n,n,res);
//         return res;
//     }

//     private void dfs(String curStr, int left, int right, List<String> res) {
//         // 递归终止条件
//         if(left==0&&right==0){
//             res.add(curStr);
//             return;
//         }
//         //因为只会出现left<=right的情况，剪枝之后就和暴力法区分开了
//         if(left>right){
//             return;
//         }
//         //每次都是进行“(”拼接，然后下一个就是“(”或者“）”不断地下探到下一层。
//         if(left>0){
//             dfs(curStr+"(",left-1,right,res);
//         }
//         // 回溯回来之后就进行其他情况的遍历，这样最终就把所有节点(情况)都遍历到了
//         if(right>0){
//             dfs(curStr+")",left,right-1,res);
//         }
//     }
// }
// @lc code=end

