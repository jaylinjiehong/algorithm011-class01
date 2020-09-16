#### [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

### java

#### 解法一：递归

-   复杂度分析
    -   时间复杂度：O(N),其中 N 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
    -   空间复杂度：O(N),使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的高度与节点个数为对数关系，即 O(logN)。而在最坏情况下，树形成链状，空间复杂度为 O(N)。

```
class Solution {
    /**
     * 递归：左子树与右子树换位置。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
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
