import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {

    /**
     * 单调栈+哨兵
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int area = 0;
        //重新给数组增加两个哨兵，哨兵的高度都是0.
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        // 使用一个栈来保存未能确定最大面积的位置，栈中的元素都是单调递增的。
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        // 遍历所有位置
        for (int i = 1; i < len; i++) {
            // 如果栈顶元素大于下一个位置，则栈顶元素所在位置的最大面积可以确定
            while (heights[stack.peekLast()] > heights[i]) {
                // 高度就是该位置的高度
                int height = heights[stack.removeLast()];
                // 宽度就是下个位置减去栈顶元素出栈后的栈顶元素所在位置，再减去1
                int width = i - stack.peekLast() - 1;
                // 计算出面积，并与之前的历史最大面积比较，得出当前最大面积
                area = Math.max(area, width * height);
            }
            // 把下一个位置加入栈顶。
            stack.addLast(i);
        }
        return area;
    }
}
// @lc code=end
