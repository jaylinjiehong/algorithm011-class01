import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    /**
     * 方法1：递归 大问题：根节点到叶子节点的值之和为sum 等价于子问题：根节点的子节点到叶子的路径和为：sum-val
     * 
     * 
     * 
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // 1、递归终止条件
        if (root == null) {
            return false;
        }
        // 2、处理当前递归层的逻辑
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // 3、递归进入下一层
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        // 4、不用保存当前层状态
    }

    /**
     * 广度优先搜索BFS 两个队列，一个保存节点，一个保存相对应节点的path值。
     * 
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 将根节点信息插入两个队列，初始化
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        // 进行迭代遍历，通过队列来进行控制终止条件
        while (!queNode.isEmpty()) {
            // 出队一个节点，分别取出信息
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            // 判断该节点是否是叶子节点
            if (now.left == null && now.right == null) {
                // 叶子节点，判断是否满足条件
                if (temp == sum) {
                    return true;
                }
                // 继续出队
                continue;
            }
            // 非叶子节点，进行入队操作
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            // 非叶子节点，进行入队操作
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}
// @lc code=end
