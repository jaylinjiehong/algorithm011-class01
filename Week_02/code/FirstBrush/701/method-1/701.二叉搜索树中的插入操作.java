/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作

 * 
 */

// @lc code=start
/**
 * * 算法：若root==null,则返回TreeNode(val)
 *      若val > root.val,插入到右子树。
 *      若val < root.val,插入到左子树。
 *      返回root。
 * 解法：1、递归
 *      2、迭代
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(val>root.val){
            // insert into the right subtree
            root.right = insertIntoBST(root.right, val);
        }else{
            // insert into the left subtree
            root.left = insertIntoBST(root.left, val);
        }
        return root;
        
    }
}
// @lc code=end

