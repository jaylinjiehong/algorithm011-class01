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
    *迭代
    */
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp!=null){
                queue.offer(tmp.left);
                queue.offer(tmp.right);
                result.add(tmp.val);
            }
        }
        int[] finalResult = new int[result.size()];
        int count=0;
        for(int i:result){
            finalResult[count++]=i;
        }
        return finalResult;
    }
}