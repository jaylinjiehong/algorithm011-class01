## [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

### java

#### 解法一：深度优先遍历

-   复杂度分析

    -   时间复杂度：O(N^2)。
    -   空间复杂度：O(N^2)。

-   对于 ArrayList 的 remove 方法，建议对索引进行操作，即 remove(int index)。而不是 remove(Object i)。

```
class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return result;
        }
        ArrayList<String> array = new ArrayList<>();
        array.add(String.valueOf(root.val));
        dfs(root,array);
        return result;
    }

    private void dfs(TreeNode node,ArrayList<String> array){
        if(node.left==null&&node.right==null){
            result.add(transferArray(array));
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left!=null){
            array.add(String.valueOf(left.val));
            dfs(left,array);
            array.remove(array.size()-1);
        }

        if(right!=null){
            array.add(String.valueOf(right.val));
            dfs(right,array);
            array.remove(array.size()-1);
        }
        return;
    }

    private String transferArray(List<String> array){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<array.size();i++){
            str.append(array.get(i));
            if(i<array.size()-1){
                str.append("->");
            }
        }
        return str.toString();
    }
}

```

### javaScript

#### 解法一：

-   复杂度分析
    -   时间复杂度：O(),
    -   空间复杂度：O(),

```

```

### kotlin

#### 解法一：

-   复杂度分析
    -   时间复杂度：O(),
    -   空间复杂度：O(),

```

```

### cpp

### c

### golang

### python3

### typeScript

### mysql

### scala

### python
