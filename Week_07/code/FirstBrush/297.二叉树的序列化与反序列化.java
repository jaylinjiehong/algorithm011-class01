import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
/**
 * 括号表示编码+递归下降解码
 */
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "X";
        }
        String l = "("+serialize(root.left)+")";
        String r = "("+serialize(root.right)+")";
        return l+root.val+r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       int[] ptr = {0};
       return parse(data,ptr);
    }

    private TreeNode parse(String data, int[] ptr) {
        if(data.charAt(ptr[0])=='X'){
            ++ptr[0];
            return null;
        }
        TreeNode cur = new TreeNode(0);
        cur.left = parseSubtree(data,ptr);
        cur.val = parseInt(data,ptr);
        cur.right = parseSubtree(data,ptr);
        return cur;
    }

    private int  parseInt(String data, int[] ptr) {
        int x =0, sgn =1;
        if(!Character.isDigit(data.charAt(ptr[0]))){
            sgn = -1;
            ++ptr[0];
        }
        while(Character.isDigit(data.charAt(ptr[0]))){
            x = x * 10+data.charAt(ptr[0]++)-'0';
        }
        return x*sgn;
    }

    private TreeNode  parseSubtree(String data, int[] ptr) {
        ++ptr[0];
        TreeNode subtree = parse(data, ptr);
        ++ptr[0];
        return subtree;
    }
    
}




/**
 * dfs+前序遍历
 */
// public class Codec {


//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {

//         return rserialize(root,"");
//     }

//     private String rserialize(TreeNode root, String str) {
//         if(root==null){
//             str+="None,";
//         }else{
//             str+=str.valueOf(root.val)+",";
//             str = rserialize(root.left, str);
//             str = rserialize(root.right, str);
//         }
//         return str;
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         String[] data_array = data.split(",");
//         List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
//         return rdeserialize(data_list);
//     }

//     private TreeNode rdeserialize(List<String> l) {
//         if(l.get(0).equals("None")){
//             l.remove(0);
//             return null;
//         }
//         TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
//         l.remove(0);
//         root.left = rdeserialize(l);
//         root.right = rdeserialize(l);
//         return root;
//     }
// }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

