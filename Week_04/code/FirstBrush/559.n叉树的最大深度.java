import javax.swing.text.AsyncBoxView.ChildLocator;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /**
     * 递归方法：N叉树的最大深度等于左右子树深度最大的值加1.
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        if(root.children.size()==0){
            return 1;
        }
        int maxDepth =0;
        for(Node node:root.children){
            maxDepth = Math.max(maxDepth, maxDepth(node));
        }
        return maxDepth+1;
    }
}
// @lc code=end

