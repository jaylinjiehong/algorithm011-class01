import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    /**
     * 1、合并后排序 时间复杂度较差，没有考虑数组本身已经有序这一点
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 2、双指针/从前往后
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 复制nums1数组
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        // 2个针对nums1_copy和nums2的get指针
        int p1 = 0;
        int p2 = 0;
        // nums1的set指针
        int p = 0;
        // 比较nums1_copy和nums2，把最小值插入nums1.
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }
        // 如果还有其中任意一个数组不为null的时候，加到后面
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    /**
     * 3、双指针：从后往前
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指向两个数组的读指针
        int p1 = m - 1;
        int p2 = n - 1;
        // nums1的写指针
        int p = m + n - 1;
        // 当有元素可以进行比较的时候
        while ((p1 >= 0) && (p2 >= 0)) {
            // 比较2个元素，把最大放到nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        // 很巧妙这里，不管什么情况，把剩下的nums2复制过来就可以了
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}
// @lc code=end
