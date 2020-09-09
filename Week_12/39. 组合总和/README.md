## [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)

### java

#### Deque

-   这个数据结构已经用过很多次了，可以开个专题研究学习其用法，以及背后的原理！

#### 解法一：

-   复杂度分析

    -   时间复杂度：O(S),O(S)，其中 SS 为所有可行解的长度之和。从分析给出的搜索树我们可以看出时间复杂度取决于搜索树所有叶子节点的深度之和，即所有可行解的长度之和。在这题中，我们很难给出一个比较紧的上界，我们知道 O(n\*(2^n))是一个比较松的上界，即在这份代码中，n 个位置每次考虑选或者不选，如果符合条件，就加入答案的时间代价。但是实际运行的时候，因为不可能所有的解都满足条件，递归的时候我们还会用 target - candidates[idx] >= 0 进行剪枝，所以实际运行情况是远远小于这个上界的

    -   空间复杂度：O(target),除答案数组外，空间复杂度取决于递归的栈深度，在最差情况下需要递归 O(target)层。

```
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        //栈
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,target, path,res);
        return res;
    }
    /**
     * 回溯+剪枝
     */
    private void dfs(int[] candidates,int begin,int target,Deque<Integer> path,List<List<Integer>> res){

        if(target==0){
            res.add(new ArrayList<>(path));
        }
        for(int i=begin;i<candidates.length;i++){
               // 剪枝
                if(target-candidates[i]<0){
                    break;
                }
                path.addLast(candidates[i]);
                dfs(candidates,i,target-candidates[i],path,res);
                // 回溯
                path.removeLast();

        }
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
