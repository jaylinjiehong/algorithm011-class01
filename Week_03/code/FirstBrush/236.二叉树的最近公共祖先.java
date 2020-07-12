import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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

    // 保存最终结果
    // private TreeNode ans;

    // public Solution(){
    //     this.ans = null;
    // }
    /**
     * 后序遍历：左右根
     * @param root
     * @param p
     * @param q
     * @return
     */
    // private boolean dfs(TreeNode root,TreeNode p,TreeNode q){
    //     // 1、recursion terminator
    //     if(root==null) return false;
    //     // 2、process logic in current level
    //     // 3、drill down
    //     boolean lson = dfs(root.left,p,q);
    //     boolean rson = dfs(root.right,p,q);
    //     // 4、reverse the current level status if needed【本层的收尾工作：判断本层所对应节点是否是最近公共祖先】
    //     if((lson&& rson)||((root.val==p.val||root.val==q.val)&&(lson||rson))){
    //         ans =root;
    //     }
    //     // 返回某个子树是否存在P或者q节点
    //     return lson || rson ||(root.val==p.val||root.val==q.val);
    // }
    /**
     * 
     * 方法一：递归解法
     * 递推公式：(f(lson)&&f(rson))||((x=p||x=q)&&(f(lson)||f(rson)))
     * @param root
     * @param p
     * @param q
     * @return
     */
    // public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    //     // 开始递归
    //     this.dfs(root,p,q);
    //     return this.ans;  
    // }

    Map<Integer,TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root){
        if(root.left!=null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    /**
     * 方法二：存储父节点
     * 1、先Map保存所有节点对应的父节点信息。
     * 2、用Set保存P和p的所有祖先父节点
     * 3、先判断q是否是p祖先父节点，再判断q的祖先父节点是否和p的某个祖先父节点相同
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
    
}
// @lc code=end

