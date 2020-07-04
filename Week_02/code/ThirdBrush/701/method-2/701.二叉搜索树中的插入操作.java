import javax.swing.tree.TreeNode;

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
 * 算法：若root=null,则返回new TreeNode(val) 
 *      若val>root.val,则插入右子树 
 *      若val<root.val，则插入左子树
 *      返回root
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode originalRoot = root;
        while (root != null) {
            if (val > root.val) {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    return originalRoot;
                } else {
                    root = root.right;
                }
            } else {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    return originalRoot;
                } else {
                    root = root.left;
                }

            }

        }
        return new TreeNode(val);
    }
}
// @lc code=end
