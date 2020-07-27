import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    private List<Integer> result = new ArrayList<>();
    /**
     * 前序遍历 迭代写法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.poll();
            result.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return result;
    }
}

// class Solution {
//     private List<Integer> result = new ArrayList<>();
//     /**
//      * 前序遍历 递归写法
//      * @param root
//      * @return
//      */
//     public List<Integer> preorderTraversal(TreeNode root) {
//         if(root==null){
//             return result;
//         }
//         result.add(root.val);
//         preorderTraversal(root.left);
//         preorderTraversal(root.right);
//         return result;
//     }
// }
// @lc code=end

