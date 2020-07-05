import java.util.Collections;
import java.util.LinkedList;

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
/**
 * 迭代方法：按照算法要求，按顺序保存要遍历的子树节点
 */

class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> myStack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        myStack.add(root);
        while (!myStack.isEmpty()) {
            Node node = myStack.pollLast();
            result.add(node.val);
            Collections.reverse(node.children);
            for (Node tempNode : node.children) {
                myStack.add(tempNode);
            }
        }
        return result;
    }
}
// @lc code=end
