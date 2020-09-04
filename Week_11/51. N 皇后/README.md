## [51. N 皇后](https://leetcode-cn.com/problems/n-queens/)

### java

#### 解法

-   [N 皇后问题]研究的是如何将 N 个皇后放置在 N X N 的棋盘上，并且使皇后彼此之间不能相互攻击。

-   方法一：基于集合的回溯

-   方法二：基于位运算的回溯

#### 复杂度分析

-   时间复杂度：O(N!)，其中 N 是皇后数量。
-   空间复杂度：O(N)。其中 N 是皇后数量。空间复杂度取决于递归调用层数、记录每行放置的皇后的列下标的数组以及三个集合，递归调用层数不会超过 N，数组的长度为 N，每个集合的元素个数都不会超过 N。

```
    /**
     *递归有关 dfs分治剪枝
     *[x,y] x是行号，y是列号
     *注意这里的N是代表取值从0...n中满足各个表达式边界的值
     *横：x相同,[x,y+N]
     *竖：y相同,[x+N,y]
     *斜线：[x+N,y+N]与[x-N,y+N]
     *方法一：把二维数组看成一维数组，可以保存历史记录，判断是否有可能，每层需要清理本层。
     *方法二：构造一个Set，保存。
     */
class Solution {
    private List<List<String>> output = new ArrayList<>();

    // 用于标记是否被列方向的皇后被攻击
    int[] rows;
    // 用于标记是否被主对角线方向的皇后攻击
    int[] mains;
    // 用于标记是否被次对角线方向的皇后攻击
    int[] secondary;
    // 用于存储皇后放置的位置
    int[] queens;

    int n;

    public List<List<String>> solveNQueens(int n) {
        // 初始化
        rows = new int[n];
        mains = new int[2 * n - 1];
        secondary = new int[2 * n - 1];
        queens = new int[n];
        this.n = n;

        // 从第一行开始回溯求解 N 皇后
        backtrack(0);

        return output;
    }

    // 在一行中放置一个皇后
    private void backtrack(int row) {
        if (row >= n) return;
        // 分别尝试在 row 行中的每一列中放置皇后
        for (int col = 0; col < n; col++) {
            // 判断当前放置的皇后不被其他皇后的攻击
            if (isNotUnderAttack(row, col)) {
                // 选择，在当前的位置上放置皇后
                placeQueen(row, col);
                // 当当前行是最后一行，则找到了一个解决方案
                if (row == n - 1) addSolution();
                // 在下一行中放置皇后
                backtrack(row + 1);
                // 撤销，回溯，即将当前位置的皇后去掉
                removeQueen(row, col);
            }
        }
    }

    // 判断 row 行，col 列这个位置有没有被其他方向的皇后攻击
    private boolean isNotUnderAttack(int row, int col) {
        // 判断的逻辑是：
        //      1. 当前位置的这一列方向没有皇后攻击
        //      2. 当前位置的主对角线方向没有皇后攻击
        //      3. 当前位置的次对角线方向没有皇后攻击
        int res = rows[col] + mains[row - col + n - 1] + secondary[row + col];
        // 如果三个方向都没有攻击的话，则 res = 0，即当前位置不被任何的皇后攻击
        return res == 0;
    }

    // 在指定的位置上放置皇后
    private void placeQueen(int row, int col) {
        // 在 row 行，col 列 放置皇后
        queens[row] = col;
        // 当前位置的列方向已经有皇后了
        rows[col] = 1;
        // 当前位置的主对角线方向已经有皇后了
        mains[row - col + n - 1] = 1;
        // 当前位置的次对角线方向已经有皇后了
        secondary[row + col] = 1;
    }

    // 移除指定位置上的皇后
    private void removeQueen(int row, int col) {
        // 移除 row 行上的皇后
        queens[row] = 0;
        // 当前位置的列方向没有皇后了
        rows[col] = 0;
        // 当前位置的主对角线方向没有皇后了
        mains[row - col + n - 1] = 0;
        // 当前位置的次对角线方向没有皇后了
        secondary[row + col] = 0;
    }

    /**
     * 将满足条件的皇后位置放入output中
     */
    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }
}

```

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
