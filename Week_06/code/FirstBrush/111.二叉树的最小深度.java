import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import jdk.internal.net.http.common.Pair;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * bfs
     * 
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level =0;
        while(!queue.isEmpty()){
            level++;
            int levelCount = queue.size();
            for(int j =0 ;j<levelCount;j++){
                TreeNode node  = queue.poll();
                if(node.left ==null && node.right == null){
                    return level;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return -1;
    }
}


// class Solution {
//     /**
//      * 递归：dfs
//      * 
//      * @param root
//      * @return
//      */
//     public int minDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         if ((root.left == null) && (root.right == null)) {
//             return 1;
//         }

//         int minDepthvalue = Integer.MAX_VALUE;
//         if (root.left != null) {
//             minDepthvalue = Math.min(minDepth(root.left), minDepthvalue);
//         }
//         if (root.right != null) {
//             minDepthvalue = Math.min(minDepth(root.right), minDepthvalue);
//         }
//         return minDepthvalue + 1;

//     }
// }
// @lc code=end
