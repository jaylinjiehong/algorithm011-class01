/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    /**
     * 动态规划 保存历史
     * 假设处于起点时（0,0）所在位置为0步位置，走了一步为f(1)
     * 递归思想：按照数学归纳法，求法f(0)最小路径和的递推公式为：f(0)=grid(0,0)+min(f(1))
     * 然后保存每一步的历史记录，因为第x步的f(x)就是当前步数的最小路径和
     * 
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int[] dpArray = new int[m * n];
        return dp(grid, m, n, 0, 0, dpArray);
    }

    private int dp(int[][] grid, int m, int n, int right, int down, int[] dpArray) {
        if (down == n - 1 && right == m - 1) {
            return grid[down][right];
        }
        if (dpArray[m * down + right] == 0) {
            if (down == n - 1) {
                dpArray[m * down + right] = grid[down][right] + dp(grid, m, n, right + 1, down, dpArray);
                return dpArray[m * down + right];
            }
            if (right == m - 1) {
                dpArray[m * down + right] = grid[down][right] + dp(grid, m, n, right, down + 1, dpArray);
                return dpArray[m * down + right];
            }

            dpArray[m * down + right] = grid[down][right]
                    + Math.min(dp(grid, m, n, right + 1, down, dpArray), dp(grid, m, n, right, down + 1, dpArray));
            return dpArray[m * down + right];
        }
        return dpArray[m * down + right];
    }
}
// @lc code=end
