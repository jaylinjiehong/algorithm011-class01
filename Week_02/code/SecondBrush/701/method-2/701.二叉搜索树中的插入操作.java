/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
 */

// @lc code=start
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
/**
 * 前提：方法的返回值是树的根节点的引用 
 * 算法：若root为null，则返回new TreeNode; 
 *      若val> root.val,则插入右子树 
 *      若val<root.val，则插入左子树 
 *      返回root 
 * 解法：1、递归 2、迭代
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode  originalRoot = root;
        while (originalRoot != null) {
            if (val > originalRoot.val) {
                if (originalRoot.right == null){
                    originalRoot.right = new TreeNode(val);
                    return root;
                }else{
                    originalRoot = originalRoot.right; 
                }
            } else {
                if (originalRoot.left == null){
                    originalRoot.left = new TreeNode(val);
                    return root;
                }else{
                    originalRoot = originalRoot.left;  
                } 
            }
        }
        return new TreeNode(val);
    }
}
// @lc code=end
