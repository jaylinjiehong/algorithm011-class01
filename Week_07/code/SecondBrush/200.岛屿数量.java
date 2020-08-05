import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    private int nums =0;
    private static final char ZERO = '0';
    private static final char ONE = '1';
    /**
     * dfs+剪枝
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row==0){
            return nums;
        }
        int col = grid[0].length;
        int[][] visited = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==ONE&&visited[i][j]==0){
                    dfs(i,j,visited,grid,row,col);
                    nums++;
                }else{
                    visited[i][j]=1;
                }
            }
        }
        return nums;
    }
    private void dfs(int i, int j, int[][] visited, char[][] grid, int row, int col) {
        if(grid[i][j]==ZERO){
            return;
        }
        visited[i][j]=1;
        if(i+1<row&&visited[i+1][j]==0){
            dfs(i+1, j, visited, grid, row, col);
        }
        if(i-1>=0&&visited[i-1][j]==0){
            dfs(i-1, j, visited, grid, row, col);
        }
        if(j+1<col&&visited[i][j+1]==0){
            dfs(i, j+1, visited, grid, row, col);
        } 
        if(j-1>=0&&visited[i][j-1]==0){
            dfs(i, j-1, visited, grid, row, col);
        }

    }
}
// @lc code=end

