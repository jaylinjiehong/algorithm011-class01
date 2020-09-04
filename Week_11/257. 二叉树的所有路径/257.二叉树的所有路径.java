/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return result;
        }
        ArrayList<String> array = new ArrayList<>();
        array.add(String.valueOf(root.val));
        dfs(root,array);
        return result;
    }

    private void dfs(TreeNode node,ArrayList<String> array){
        if(node.left==null&&node.right==null){
            result.add(transferArray(array));
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left!=null){
            array.add(String.valueOf(left.val));
            dfs(left,array);
            array.remove(array.size()-1);
        }

        if(right!=null){
            array.add(String.valueOf(right.val));
            dfs(right,array);
            array.remove(array.size()-1);
        }
        return;
    }

    private String transferArray(List<String> array){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<array.size();i++){
            str.append(array.get(i));
            if(i<array.size()-1){
                str.append("->");
            }
        }
        return str.toString();
    }
}
// @lc code=end

