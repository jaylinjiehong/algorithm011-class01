/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */
/**
 * 假如把题目移动换成是左移，一种思路是把左移变成右移， 一种是直接按照左移思想，对各种解法进行逻辑修改
 */

// @lc code=start
class Solution {
    /**
     * 1、暴力法
     * 
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int previous, temp;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 2、额外数组法
     * 
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    /**
     * 3、环状替换
     * 
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        // 使得k不跳过数组一圈。
        k = k % nums.length;
        int count = 0;
        // 数组有n个数，只需n次移动就完事
        for (int start = 0; count < nums.length; start++) {
            // 保存当前位置的信息
            int current = start;
            int prev = nums[start];
            // 使用do-while目的是保证start==current的时候，
            // start位置上的数已经被前一个跳跃过来的数代替了，完美！
            // 这个和方法1用previous = nums[nums.length - 1];有种奇妙关系。
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * 4、反转 事实：当我们旋转数组k次，k%n个尾部元素会被移动到头部， 剩下的元素会被向后移动。
     * 我们首先将所有元素反转，然后反转前k个元素，再反转后面n-k个元素， 就能得到想要的结果了。
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
// @lc code=end
