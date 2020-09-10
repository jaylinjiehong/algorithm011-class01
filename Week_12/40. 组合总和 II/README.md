#### [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)

### java

#### 解法一：

-   复杂度分析
    -   时间复杂度：O(),
    -   空间复杂度：O(),

```java
class Solution {
    /**
     * 回溯+剪枝
     * 关键是如何去重！
     * 每个数字只能出现一次，是否可以找到一个键，保存住唯一的索引信息，字符串可以申请一战！
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(res,candidates,candidates.length,-1,target,stack);
        return res;
    }

    private void dfs(List<List<Integer>> res,int[] candidates,int len,int begin, int target,Deque<Integer> stack){
        
       
        if(target==0){
            res.add(new ArrayList<>(stack));
            return;
        }
        //当begin>=len时，发现i>=len,这里就被剪枝
        for(int i=begin+1;i<len;i++){
               // 大剪枝
                if(target-candidates[i]>=0){
                        // 小剪枝
                     if (i > begin+1 && candidates[i] == candidates[i - 1]) {
                        continue;
                     }
                     

                    stack.addLast(candidates[i]);
                    dfs(res,candidates,len,i,target-candidates[i],stack);
                    stack.removeLast();
                }
            
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
