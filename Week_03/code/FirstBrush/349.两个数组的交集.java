import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    /**
     * 1、哈希方法
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> firstNums = new HashMap<>();
        int[] result = new int[nums1.length];
        int count = 0;
        for (int i : nums1) {
            firstNums.put(i, 1);
        }
        for (int i : nums2) {
            if (firstNums.containsKey(i)) {
                result[count] = i;
                count++;
                firstNums.remove(i);
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * 哈希方法的两个Set的写法
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        if (set1.size() >= set2.size()) {
            return get_intersection(set1, set2);
        } else {
            return get_intersection(set2, set1);
        }
    }

    /**
     * 获取两个Set的交集
     * 
     * @param bigSet
     * @param littleSet
     * @return
     */
    private int[] get_intersection(HashSet<Integer> bigSet, HashSet<Integer> littleSet) {
        int[] result = new int[littleSet.size()];
        int count = 0;
        for (Integer i : littleSet) {
            if (bigSet.contains(i)) {
                result[count] = i;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * 方法2：采用HashSet的内置函数进行取交集操作
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int count = 0;
        for (int i : set1) {
            result[count++] = i;
        }
        return result;

    }

}
// @lc code=end
