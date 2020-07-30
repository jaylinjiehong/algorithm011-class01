import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
     * 迭代dfs
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            result.add(node.val);
            for(int i = node.children.size()-1;i>=0;i--){
                if(node.children.get(i)!=null){
                    stack.push(node.children.get(i));
                }
            }
        }
        return result;
    }
}
// @lc code=end

