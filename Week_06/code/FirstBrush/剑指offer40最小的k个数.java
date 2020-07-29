class Solution {
    /**
     * 方法1：最简单的就是排序
     * 方法2：采用建堆的方式（大根堆【大顶堆】保存前k个最小的值）
     * 方法3：快排算法
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = Arrays.copyOfRange(arr,0,k);
        return result;

    }
}

