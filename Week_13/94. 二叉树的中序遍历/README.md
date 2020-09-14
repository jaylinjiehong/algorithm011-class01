#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

### java

#### 解法一：递归解法

-   复杂度分析
    -   时间复杂度：O(),
    -   空间复杂度：O(),

```
class Solution {
    private List<Integer> res = new ArrayList<>();
    /**
     * 递归解法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return res;
        }
        if(root.left!=null){
            inorderTraversal(root.left);
        }
        res.add(root.val);

        if(root.right!=null){
            inorderTraversal(root.right);
        }

        return res;
    }
}
```

#### 解法二：迭代解法

-   复杂度分析
    -   时间复杂度：O(),
    -   空间复杂度：O(),

```

class Solution {
    private List<Integer> res = new ArrayList<>();
    /**
     * 迭代解法：左根右：左子树：左根右、右子树：左根右  最终顺序：[左子树左、左子树根、左子树右、根、右子树左、右子树根、右子树右]
     * 栈：先进后出
     * 队列：后进先出
     * 算法解析：1、定义一个栈：用于模拟递归的函数栈；定义一个集合：存储已经解析过的结点。
     *          2、当结点没有解析时，需要递归解析；都解析完的结构应该是这样（模拟的，实际上会左子树会先被解析和出栈）：[左子树左、左子树根、左子树右、根、右子树左、右子树根、右子树右]
     *          3、解析完的节点，按照栈的顺序出栈就对了！
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited  = new HashSet<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.removeLast();
            if(!visited.contains(node)){
                if(node.right!=null){
                    stack.addLast(node.right);
                }
                stack.addLast(node);
                visited.add(node);
                if(node.left!=null){
                    stack.addLast(node.left);
                }
            }else{
                res.add(node.val);
            }

        }
        return res;
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
