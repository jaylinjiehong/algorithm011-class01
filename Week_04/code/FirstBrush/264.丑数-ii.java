import java.util.HashSet;
import java.util.PriorityQueue;

import sun.rmi.runtime.NewThreadAction;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public static Ugly u = new Ugly();

    /**
     * 
     * 
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }
}

/**
 * 2、动态规划 通过三指针方法
 */
class Ugly {
    public int[] nums = new int[1690];

    Ugly() {
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < 1690; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2) {
                ++i2;
            }
            if (ugly == nums[i3] * 3) {
                ++i3;
            }
            if (ugly == nums[i5] * 5) {
                ++i5;
            }

        }
    }
}

/**
 * 1、堆
 */
// class Ugly {
// public int[] nums = new int[1690];

// Ugly() {
// HashSet<Long> seen = new HashSet();
// PriorityQueue<Long> heap = new PriorityQueue<>();
// seen.add(1L);
// heap.add(1L);

// long currUgly, newUgly;
// int[] prims = new int[] { 2, 3, 5 };
// for (int i = 0; i < 1690; i++) {
// currUgly = heap.poll();
// nums[i] = (int) currUgly;
// for (int j : prims) {
// newUgly = currUgly * j;
// if (!seen.contains(newUgly)) {
// seen.add(newUgly);
// heap.add(newUgly);
// }
// }
// }
// }
// }
// @lc code=end
