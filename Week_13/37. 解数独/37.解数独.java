/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    /**
     * 回溯+剪枝 记录记忆
     * 
     * @param board
     */
    public void solveSudoku(char[][] board) {
        int[][] rowHistory = new int[10][10];
        int[][] colHistory = new int[10][10];
        int[][] winHistory = new int[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowHistory[i + 1][board[i][j] - '0'] = 1;
                    colHistory[j + 1][board[i][j] - '0'] = 1;
                    winHistory[(i / 3) * 3 + j % 3][board[i][j] - '0'] = 1;
                }

            }
        }
        backTrack(board, 0, rowHistory, colHistory, winHistory);
    }

    private static boolean hasFinished = false;

    private void backTrack(char[][] board, int index, int[][] rowHistory, int[][] colHistory, int[][] winHistory) {
        if (hasFinished) {
            return;
        }
        if (index > 80) {
            hasFinished = true;
            return;
        }
        int row = index / 9;
        int col = index % 9;

        if (board[row][col] != '.') {
            backTrack(board, index + 1, rowHistory, colHistory, winHistory);
        } else {
            for (char i = 1; i <= 9; i++) {
                if (rowHistory[row + 1][i] != 1 && colHistory[col + 1][i] != 1
                        && winHistory[(row / 3) * 3 + col % 3][i] != 1) {

                    // 保存历史记录
                    board[row][col] = (char) ('0' + i);
                    rowHistory[row + 1][i] = 1;
                    colHistory[col + 1][i] = 1;
                    winHistory[(row / 3) * 3 + col % 3][i] = 1;
                    // 递归
                    backTrack(board, index + 1, rowHistory, colHistory, winHistory);
                    // 回溯历史记录
                    if (!hasFinished) {
                        board[row][col] = '.';
                        rowHistory[row + 1][i] = 0;
                        colHistory[col + 1][i] = 0;
                        winHistory[(row / 3) * 3 + col % 3][i] = 0;
                    }
                }
            }
        }
    }
}
// @lc code=end
