import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    /**
     * 动态规划
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      if (n * k == 0) {
          return new int[0];
      }
      if (k == 1){

       return nums;
      }
  
      int [] left = new int[n];
      left[0] = nums[0];
      int [] right = new int[n];
      right[n - 1] = nums[n - 1];
      for (int i = 1; i < n; i++) {
        // from left to right
        if (i % k == 0) {
            // block_start 
            left[i] = nums[i]; 
        }
        else {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
  
        // from right to left
        int j = n - i - 1;
        if ((j + 1) % k == 0) {
            // block_end
            right[j] = nums[j];  
        }
        else {
            right[j] = Math.max(right[j + 1], nums[j]);
        }
      }
  
      int [] output = new int[n - k + 1];
      for (int i = 0; i < n - k + 1; i++){
        output[i] = Math.max(left[i + k - 1], right[i]);
      }
  
      return output;
    }
  }



// class Solution {
//     /**
//      * 双向队列
//      */
//     ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
//     int[] nums;

//     public void cleanDeque(int i, int k) {
//         // remove indexes of elements not from sliding window
//         if (!deq.isEmpty() && deq.getFirst() == i - k){
//             deq.removeFirst();
//         }
           

//         // remove from deq indexes of all elements
//         // which are smaller than current element nums[i]
//         while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
//             deq.removeLast();
//         }
            
//     }

//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         if (n * k == 0){
//             return new int[0];
//         }
         
//         if (k == 1){
//             return nums;
//         }
        

//         // init deque and output
//         this.nums = nums;
//         int maxIdx = 0;
//         for (int i = 0; i < k; i++) {
//             cleanDeque(i, k);
//             deq.addLast(i);
//             // compute max in nums[:k]
//             if (nums[i] > nums[maxIdx]){
//                 maxIdx = i;
//             }
              
//         }
//         int[] output = new int[n - k + 1];
//         output[0] = nums[maxIdx];

//         // build output
//         for (int i = k; i < n; i++) {
//             cleanDeque(i, k);
//             deq.addLast(i);
//             output[i - k + 1] = nums[deq.getFirst()];
//         }
//         return output;
//     }
// }

// class Solution {
// /**
// * 暴力法
// * @param nums
// * @param k
// * @return
// */
// public int[] maxSlidingWindow(int[] nums, int k) {
// int n = nums.length;
// if(n*k==0){
// return new int[0];
// }
// int[] output = new int[n-k+1];
// for(int i=0;i<n-k+1;i++){
// int max = Integer.MIN_VALUE;
// for(int j=i;j<i+k;j++){
// max = Math.max(max,nums[j]);

// }
// output[i] = max;
// }
// return output;

// }
// }
// @lc code=end
