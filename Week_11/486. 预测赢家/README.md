## [486. 预测赢家](https://leetcode-cn.com/problems/predict-the-winner/)

### java

-   尴尬的是，做这道题目的时候，审题审错了，误以为是先把数组排序，每次取倒数第二大的值，然后直接码代码，写着写着就断了，没做递归时的找最近最简方法，将其拆解成可重复解决的问题（重复子问题），也没用数学归纳法验证，写代码过程中陷入人肉递归不能自拔。
-   看代码应该算是分治算法。

#### 方法一：递归

-   为了判断哪个玩家可以获胜，需要计算一个总分，为先手得分与后手得分之差。当数组中的所有数字都被拿取时，如果总分大于或等于 0，则先手获胜，反之则后手获胜。
-   由于每次只能从数组的任意一端拿取数字，因此可以保证数组中剩下的部分一定是连续的。假设数组当前剩下的部分为下标 start 到下标 end，其中 0<= start<=end<nums.length。如果 start=end，则只剩下一个数字，当前玩家只能拿取这个数字。如果 start<end，则当前玩家可以选择 nums[start]或 nums[end]，然后轮到另一个玩家在数组剩下的部分选取数字。这是一个递归的过程。
-   计算总分时，需要记录当前玩家是先手还是后手，判断当前玩家的得分应该记为正还是负。当数组中剩下的数字多余 1 个时，当前玩家会选择最优的方案，使得自己的分数最大化，因此对两种方案分别计算当前玩家可以得到的分数，其中的最大值为当前玩家最多可以得到的分数。

```

class Solution {
    /**
     * 方法1、递归、分治
     * 方法2、动态规划
     */
    public boolean PredictTheWinner(int[] nums) {
        // 递归，算总分，正手得分为正，反手得分为负，每轮从数组两端找最大值。（每个玩家都会找最大值）
        return total(nums,0,nums.length-1,1)>=0;
    }
    private int total(int[] nums,int start,int end,int turn){
        // 1、递归终止条件
        if(start == end){
            return nums[start]*turn;
        }
        // 2、处理本层逻辑：每次总是找总分的最大值 3、下探到下一层
        int scoreStart = nums[start]*turn + total(nums,start+1,end,-turn);
        int scoreEnd = nums[end]*turn+total(nums,start,end-1,-turn);
        // 4、保存本层状态：找出本轮最大值的（之所以会乘以turn，是为了让反手时也选择分数最大的）
        return Math.max(scoreStart*turn,scoreEnd*turn)*turn;
    }
}

```

-   复杂度分析

    -   时间复杂度：O(2^n)，其中 n 是数组的长度
    -   空间复杂度：O(n)，其中 n 是数组的长度。空间复杂度取决于递归使用的栈空间。

#### 递归代码模板

```
public void recur(int level,int param){
    // terminator
    if(level>MAX_LEVEL){
        //process result
        return;
    }
    //process current logic
    process(level,param);

    //drill down
    recur(level:level+1,newParam);

    //restore current status
}

```

#### 分治代码模板

```

def divide_conquer(problem,param1,param2,...){
    #recursion terminator
    if problem is None:
        print_result
        return

    #prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem,data)

    # conquer subproblems
    subresult1  = self.divide_conquer(subproblems[0],p1,...)
    subresult2  = self.divide_conquer(subproblems[1],p1,...)
    subresult3  = self.divide_conquer(subproblems[2],p1,...)
    ...

    # process and generate the final result
    result = process_result(subesult1,subresult2,subresult3,...)

    # revert the current level states

}

```

### 方法二：动态规划

#### 关键点

-   动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）
-   共性：找到重复子问题
-   差异性：最优子结构、中途可以淘汰次优解

#### 动态规划关键点

-   1、最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
-   2、储存中间状态：opt[i]
-   3、递推公式（美其名曰：状态转移方程或者 DP 方程）
    -   Fib：opt[i] = opt[n-1]+opt[n-2]
    -   二维路径：opt[i,j] = opt[i+1][j]+opt[i][j+1](且判断 a[i,j]是否空地)

#### 动态规划小结

-   1、打破自己的思维惯性，形成机器思维
-   2、理解复杂逻辑的关键
-   3、也是职业进阶的要点要领。

### javaScript

### kotlin

### cpp

### c

### golang

### python3

### typeScript

### mysql

### scala

### python
