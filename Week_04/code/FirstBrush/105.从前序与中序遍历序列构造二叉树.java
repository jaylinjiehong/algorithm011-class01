import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
     * 递归解法：只要按照前序遍历和中序遍历的定义进行分析。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length){
            return null;
        }
        int length = preorder.length;
        Map<Integer,Integer> map = new HashMap<>(length);
        for(int i=0;i<length;i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder,0,length-1,map,0,length-1);

    }

    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if(preLeft>preRight||inLeft>inRight){
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int inRoot = map.get(rootVal);

        root.left = buildTree(preorder, preLeft+1, inRoot-inLeft+preLeft, map, inLeft, inRoot-1);
        root.right = buildTree(preorder, inRoot-inLeft+preLeft+1, preRight, map, inRoot+1, inRight);
        return root;
    }
}

class Solution1{
    /**
     * 迭代
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
// @lc code=end

