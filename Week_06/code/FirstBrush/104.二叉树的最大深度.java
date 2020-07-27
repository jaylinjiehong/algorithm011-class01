import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
     * dfs:递归写法
     * 时间复杂度：O(n)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// class Solution {
//     /**
//      * bfs：迭代写法
//      * @param root
//      * @return
//      */
//     public int maxDepth(TreeNode root) {
//         if(root==null){
//             return 0;
//         }
//         Queue<TreeNode> queue = new LinkedList<>();
//         int steps =0;
//         queue.offer(root);
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             for(int i=0;i<size;i++){
//                 TreeNode node = queue.poll();
//                 if(node.left!=null){
//                     queue.offer(node.left);
//                 }
//                 if(node.right!=null){
//                     queue.offer(node.right);
//                 }
//             }
//             steps++;
//         }
//         return steps;
//     }
// }
// @lc code=end

