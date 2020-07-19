import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
// class Solution {
//     /**
//      * 遍历二维矩阵，第一个1的看作无向图的根节点，进行深度优先搜索，访问节点设置为0
//      * 
//      * @param grid
//      * @return
//      */
//     public int numIslands(char[][] grid) {
//         int rowLength = grid.length;
//         if (rowLength == 0) {
//             return 0;
//         }
//         int columnLength = grid[0].length;

//         int numIslands = 0;
//         for (int row = 0; row < rowLength; row++) {
//             for (int column = 0; column < columnLength; column++) {
//                 if (grid[row][column] == '1') {
//                     numIslands++;
//                     dfs(grid, row, column);
//                 }
//             }
//         }
//         return numIslands;
//     }
//     /**
//      * 深度优先遍历
//      * 
//      * @param grid
//      * @param row
//      * @param column
//      */
//     public void dfs(char[][] grid, int row, int column) {
//         int rowLength = grid.length;
//         int columnLength = grid[0].length;

//         grid[row][column] = '0';

//         if (row - 1 >= 0 && grid[row - 1][column] == '1') {
//             dfs(grid, row - 1, column);
//         }
//         if (row + 1 < rowLength && grid[row + 1][column] == '1') {
//             dfs(grid, row + 1, column);
//         }
//         if (column - 1 >= 0 && grid[row][column - 1] == '1') {
//             dfs(grid, row, column - 1);
//         }
//         if (column + 1 < columnLength && grid[row][column + 1] == '1') {
//             dfs(grid, row, column + 1);
//         }
//     }
// }


class Solution {
    /**
     * 遍历二维矩阵，第一个1的看作无向图的根节点，进行广度优先搜索，访问节点设置为0
     * 
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int rowLength = grid.length;
        if(rowLength==0){
            return 0;
        }
        int columnLength = grid[0].length;

        int numIslands = 0;

        for(int row=0;row<rowLength;row++){
            for(int column =0;column<columnLength;column++){
                if(grid[row][column]=='1'){
                    numIslands++;
                    grid[row][column]='0';
                    Queue<Integer> nodes = new LinkedList<>();
                    nodes.add(row*columnLength+column);
                    while(!nodes.isEmpty()){
                        int node = nodes.remove();
                        int tempRow = node/columnLength;
                        int tempColumn = node %columnLength;
                        if(tempRow-1>=0&&grid[tempRow-1][tempColumn]=='1'){
                            grid[tempRow-1][tempColumn]='0';
                            nodes.add((tempRow-1)*columnLength+tempColumn);
                        }
                        if(tempRow+1<rowLength&&grid[tempRow+1][tempColumn]=='1'){
                            grid[tempRow+1][tempColumn]='0';
                            nodes.add((tempRow+1)*columnLength+tempColumn);
                        }
                        if(tempColumn-1>=0&&grid[tempRow][tempColumn-1]=='1'){
                            grid[tempRow][tempColumn-1]='0';
                            nodes.add(tempRow*columnLength+tempColumn-1);
                        }
                        if(tempColumn+1<columnLength&&grid[tempRow][tempColumn+1]=='1'){
                            grid[tempRow][tempColumn+1]='0';
                            nodes.add(tempRow*columnLength+tempColumn+1);
                        }
                    }
                }
            }
        }
        return numIslands;
    }
}
// @lc code=end
