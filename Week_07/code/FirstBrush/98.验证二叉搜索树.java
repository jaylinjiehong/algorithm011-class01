import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;


/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 中序遍历+迭代
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = -Double.MAX_VALUE;

        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root =root.left;
            }
            root = stack.pop();
            if(root.val<=inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
       return true;
    }
}



// class Solution {
//     /**
//      * 递归+一个边界值区间（left，right）,来确定左右子树是否满足条件
//      * @param root
//      * @return
//      */
//     public boolean isValidBST(TreeNode root) {
//         return helper(root,null,null);
//     }

//     private boolean helper(TreeNode node, Integer lower, Integer upper) {
//         if(node==null){
//             return true;
//         }
//         int val = node.val;
//         if(lower!=null&&val<=lower){
//             return false;
//         }
//         if(upper!=null&&val>=upper){
//             return false;
//         }

//         if(!helper(node.right, val, upper)){
//             return false;
//         }
//         if(!helper(node.left, lower, val)){
//             return false;
//         }
//         return true;
//     }
// }





// class Solution {
//     /**
//      * 左根右的中序遍历+遍历数组比较
//      * @param root
//      * @return
//      */
//     public boolean isValidBST(TreeNode root) {
//         List<Integer> nodes = new ArrayList<>();
//         dfs(root,nodes);
//         for(int i=0;i+1<nodes.size();i++){
//             if(nodes.get(i)>=nodes.get(i+1)){
//                 return false;
//             }
//         }
//         return true;
//     }

//     private void dfs(TreeNode root, List<Integer> nodes) {
//         if(root==null){
//             return;
//         }
//         dfs(root.left,nodes);
//         nodes.add(root.val);
//         dfs(root.right,nodes);
//     }
// }
// @lc code=end

