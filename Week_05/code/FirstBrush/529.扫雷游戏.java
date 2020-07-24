import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    /**
     * DFS
     * 
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        backTrack(board, click[0], click[1]);
        return board;
    }
    private void backTrack(char[][] board, int x, int y) {
        // 递归终止条件:
      
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
            return;
        }
        if (board[x][y] != 'E') {
            return;
        }
        // 处理本层逻辑
        int mCount =countNum(board,x,y);
       
        if (mCount > 0) {
        board[x][y] = (char) (mCount+'0');
        return;
        }
        board[x][y] = 'B';
        // 下探到下一层
        backTrack(board, x - 1, y - 1);
        backTrack(board, x - 1, y);
        backTrack(board, x - 1, y + 1);
        backTrack(board, x, y-1);
        backTrack(board, x, y + 1);
        backTrack(board, x + 1, y - 1);
        backTrack(board, x + 1, y);
        backTrack(board, x + 1, y + 1);
    }

    private int countNum(char[][] board, int x, int y) {
        int mCount =0;
        if (x - 1 >= 0 && y + 1 < board[0].length && board[x - 1][y + 1] == 'M') {
            mCount++;
        }

        if (x - 1 >= 0 && board[x - 1][y] == 'M') {
            mCount++;
        }

        if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 'M') {
            mCount++;
        }

        if (y + 1 < board[0].length && board[x][y + 1] == 'M') {
            mCount++;
        }

        if (y - 1 >= 0 && board[x][y - 1] == 'M') {
            mCount++;
        }

        if (x + 1 < board.length && y + 1 < board[0].length && board[x + 1][y + 1] == 'M') {
            mCount++;
        }

        if (x + 1 < board.length && board[x + 1][y] == 'M') {
            mCount++;
        }

        if (x + 1 < board.length && y - 1 >= 0 && board[x + 1][y - 1] == 'M') {
            mCount++;
        }
        return mCount;
    }
    
}
// @lc code=end
