import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.org.apache.bcel.internal.classfile.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
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
     * 方法1：利用队列实现广度优先搜索
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                tempList.add(node.val);
                queue.addAll(node.children);
            }
            result.add(tempList);
        }
        return result;

    }

    /**
     * 2、简化的广度优先搜索 使用数组来进行保存
     * 
     * @param root
     * @return
     */
    // public List<List<Integer>> levelOrder2(Node root) {
    // List<List<Integer>> result = new ArrayList<>();
    // if (root == null) {
    // return result;
    // }

    // List<Node> previousLayer = new ArrayList<>();
    // previousLayer.add(root);
    // while (!previousLayer.isEmpty()) {
    // List<Integer> previousVal = new ArrayList<>();
    // List<Node> currentLayer = new ArrayList<>();
    // for (Node node : previousLayer) {
    // previousVal.add(node.val);
    // currentLayer.addAll(node.children);
    // }
    // result.add(previousVal);
    // previousLayer = currentLayer;
    // }
    // return result;

    // }
    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 3、递归方法 通过level来进行分层区分：确定哪个时候进行add(new ArrayList())
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) {
            traverseNode(root, 0);
        }
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node temp : node.children) {
            traverseNode(temp, level + 1);
        }

    }

}
// @lc code=end
