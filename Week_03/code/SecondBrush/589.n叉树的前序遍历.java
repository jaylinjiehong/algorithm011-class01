import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
     * 前序遍历：根左右 递归:终止条件 1、递归法
     * 
     * @param root
     * @return
     */
    private List<Integer> allValues = new ArrayList<>();

    public List<Integer> preorder1(Node root) {
        if (root == null) {
            return allValues;
        }
        allValues.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return allValues;
    }

    /**
     * 2、迭代法 由于问题分解成2个子问题，循环比较难处理，因此需要整理成一个子问题，然后循环
     * 
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {

        List<Integer> allValues = new ArrayList<>();
        LinkedList<Node> allNodes = new LinkedList<>();
        while (root != null) {
            allValues.add(root.val);
            // 反转顺序
            Collections.reverse(root.children);
            for (Node node : root.children) {
                if (node != null) {
                    allNodes.add(node);
                }
            }
            root = allNodes.pollLast();
        }
        return allValues;
    }
}
// @lc code=end
