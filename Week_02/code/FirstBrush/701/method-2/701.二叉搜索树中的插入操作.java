/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
 */

// @lc code=start
/**
 * 算法： 若root==null,则返回新的TreeNode节点
 *        若val>root.right,则插入右子树root
 *        若val<root.left,则插入左子树
 *       返回root
 *解法：1、递归 2、迭代
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
        TreeNode tempNode = root;
        while(tempNode != null){
            if(val>tempNode.val){
                //insert new node into right tree
                if(tempNode.right==null){
                    tempNode.right = new TreeNode(val);
                    return root;
                }else{
                    tempNode = tempNode.right;
                }

            }else{
                //insert new node into leght tree
                if(tempNode.left ==null){
                    tempNode.left = new TreeNode(val);
                    return root;
                }else{
                    tempNode = tempNode.left;
                }
            }
        }
        return new TreeNode(val);  
    }
}
// @lc code=end

