import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
 * 递归 类比二叉树的前序遍历：根左右
 */
class Solution {
    List<Integer> tempInt = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return tempInt;
        }
        tempInt.add(root.val);
        for (Node temp : root.children) {
            preorder(temp);
        }
        return tempInt;
    }
}
// @lc code=end
