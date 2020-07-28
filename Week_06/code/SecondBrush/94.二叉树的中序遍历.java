/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
     * 迭代:体会前序遍历与中序遍历的区别。这里while的用法与子树的关系，说明了什么？
     * 为何不是if了，而是while？值得深思与记忆代码模板！！！
     * 栈的作用永远是:先进后出！！！
     * 根据访问节点的顺序进行入栈出栈构造，目的是为了满足“中序遍历”的需求！！！
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            } 
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}


// class Solution {
//     private List<Integer> result = new ArrayList<>();
//     /**
//      * 递归
//      */
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root==null){
//             return result;
//         }
//         inorderTraversal(root.left);
//         result.add(root.val);
//         inorderTraversal(root.right);
//         return result;
//     }
// }
// @lc code=end

