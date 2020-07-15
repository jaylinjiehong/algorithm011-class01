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
    /**
    *迭代:BFS遍历
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode tmp = queue.poll();
                if(tmp!=null){
                    arrayList.add(tmp.val);
                    if(tmp.left!=null){
                        queue.offer(tmp.left);
                    }
                    if(tmp.right!=null){
                        queue.offer(tmp.right);
                    }
                }
            }  
            result.add(arrayList); 
        }
        return result;
    }
}