import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    private List<Integer> allNodes1 = new ArrayList<>();

    /**
     * 1、递归法 前序遍历：根左右（所有子树）
     * 
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        if (root == null) {
            return allNodes1;
        }
        allNodes1.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return allNodes1;

    }

    /**
     * 2、迭代法:需要栈保存
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> allNodes = new LinkedList<>();

        //也是栈
        LinkedList<Node> stack = new LinkedList<>();
        if(root==null){
            return allNodes;
        }
        //栈空则迭代完成：因为栈元素肯定不是null
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            allNodes.add(node.val);
            Collections.reverse(node.children);
            for(Node item: node.children){
                stack.add(item);
            }
        }
        return allNodes;
    }
}
// @lc code=end
