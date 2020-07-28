import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
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
    private LinkedList<Integer> result = new LinkedList<>();
    /**
     * 迭代：dfs用栈
     * N叉树的后序遍历与N叉树树的前序遍历有点关系，请死记硬背这个微妙的关系！！！
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if(root==null){
            return result;
        }
        // 双端队列：需要对常用的API进行死记硬背！！！
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            result.addFirst(node.val);
            for(Node item: node.children){
                if(item!=null){
                    stack.add(item);
                }

            }
            
        }
        return result;
    }
}

// class Solution {
//     private List<Integer> result = new ArrayList<>();
//     /**
//      * 递归：左右根
//      * @param root
//      * @return
//      */
//     public List<Integer> postorder(Node root) {
//         if(root==null){
//             return result;
//         }
//         for(Node node:root.children){
//             postorder(node);
//         }
//         result.add(root.val);
//         return result;
//     }
// }
// @lc code=end

