import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * 1、递归法
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> allNodes = new ArrayList<>();
        inorder(root, allNodes);
        return allNodes;
    }

    /**
     * 递归：左根右
     * 
     * @param root
     * @param allNodes
     */
    private void inorder(TreeNode root, List<Integer> allNodes) {
        // 不为空时，才进行遍历
        if (root != null) {
            if (root.left != null) {
                inorder(root.left, allNodes);
            }
            allNodes.add(root.val);
            if (root.right != null) {
                inorder(root.right, allNodes);
            }
        }
    }

    /**
     * 
     * 2、迭代法（基于栈的遍历） 左根右是中序遍历 由于递归的函数栈是通过系统帮我们实现的， 因此需要自己实现一个栈来保存
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> allNodes = new ArrayList<>();
        Stack<TreeNode> stashNoeds = new Stack<>();
        TreeNode curr = root;
        // 完全按照实际的“左根右”来构造循环
        while (curr != null || !stashNoeds.isEmpty()) {
            while (curr != null) {
                stashNoeds.push(curr);
                curr = curr.left;
            }
            curr = stashNoeds.pop();
            allNodes.add(curr.val);
            curr = curr.right;
        }
        return allNodes;
    }

    /**
     * 线索二叉树 莫里斯遍历 通过对中序遍历的线索路径进行理解，按照线索把树给捋直成线段。
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        // 判断是否为空树
        while (curr != null) {
            // 没有左子树
            if (curr.left == null) {
                // 根节点没有左子树时，把根节点的值加到数组中
                res.add(curr.val);
                // 移动到右节点
                curr = curr.right;
            } else {
                // 有左子树
                pre = curr.left;
                while (pre.right != null) {
                    // 找到最右节点
                    pre = pre.right;
                }
                // 把根节点拼接在最右子节点的右子节点
                pre.right = curr;
                // 暂存根节点
                TreeNode temp = curr;
                // 将根节点转换为原根节点的左子节点
                curr = curr.left;
                // 原根节点的左节点设置为null，避免无限循环
                temp.left = null;
            }
        }
        return res;
    }

}
// @lc code=end
