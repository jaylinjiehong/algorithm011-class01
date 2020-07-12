import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;

import jdk.nashorn.internal.ir.ReturnNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    int postIdx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
  
    public TreeNode helper(int inLeft, int inRight) {

      if (inLeft > inRight){
        return null;
      }
      int rootVal = postorder[postIdx];
      TreeNode root = new TreeNode(rootVal);

      int index = idxMap.get(rootVal);
      postIdx--;
      root.right = helper(index + 1, inRight);
      root.left = helper(inLeft, index - 1);
      return root;
    }
  
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      this.postorder = postorder;
      this.inorder = inorder;
      postIdx = postorder.length - 1;
      int idx = 0;
      for (Integer val : inorder){
        idxMap.put(val, idx++);
      }
      return helper(0, inorder.length - 1);
    }



    //1、递归终止条件
    // 2、处理本层逻辑
    // 3、下探到子问题
    // 4、清理本层
}

// @lc code=end


// def recursion(level,param1,param2,...):
//     #recursion terminator
//     if level>MAX_LEVEL:
//     process_result
//     return 

//     #process logic in current level
//     process(level,data...)

//     #drill down
//     self.recursion(level+1,p1,...)

//     # reverse the current level status if needed



// def divide_conquer(problem,param1,param2,...):
//     #recursion terminator
//     if problem is None:
//         print_result
//         return 
//     # prepare data
//     data = prepare_data(problem)
//     subproblems = split_problem(problem,data)
//     # conquer subproblems
//     subresult1 = self.divide_conquer(subproblems[0],p1,...)
//     subresult2 = self.divide_conquer(subproblems[1],p1,...)
//     subresult3 = self.divide_conquer(subproblems[2],p1,...)
//     ...
//     # process and generate the final Result
//     result = process_result(subresult1,subresult2,...)
//     #revert the current level states.