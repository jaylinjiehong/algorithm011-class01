import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    /**
     * 1、暴力法：按列求
     * @param height
     * @return
     */
    // public int trap1(int[] height) {
    //     int ans = 0;
    //     for(int i=0;i<height.length;i++){
    //         int max_left=0;
    //         int max_right=0;
    //     
    //         for(int j=i;j>=0;j--){
    //             max_left =max(max_left,height[j]);
    //         }
    //         
    //         for(int j=i;j<height.length;j++){
    //             max_right = max(max_right,height[j]);
    //         }
    //         ans+=min(max_left,max_right)-height[i];
    //     }
    //     return ans;

    // }
    // private int max(int left,int right){
    //     return left>right?left:right;
    // }
    // private int min(int left,int right){
    //     return left<right?left:right;
    // }



    /**
     * 方法2：动态编程：动态规划
     * 在暴力方法中，我们仅仅为了找到最大值每次都要向左和向右扫描一次。
     * 但是我们可以提前存储这个值。因此，可以通过动态编程解决。
     * @param height
     * @return
     */
    // public int trap2(int[] height) {

    //     if(height==null||height.length==0){
    //         return 0;
    //     }
    //     int ans =0;
    //     int size = height.length;
    //     int[] left_max = new int[size];
    //     int[] right_max = new int[size];

    //     left_max[0] = height[0];
    //     for(int i=1;i<size;i++){
    //         left_max[i] = max(height[i], left_max[i-1]);
    //     }

    //     right_max[size-1] = height[size-1];
    //     for(int i=size-2;i>=0;i--){
    //         right_max[i] =max(height[i], right_max[i+1]);
    //     }

    //     for(int i=1;i<size-1;i++){
    //         ans+=min(left_max[i],right_max[i])-height[i];
    //     }
    //     return ans;
    // }


    /**
     * 方法3：按行求
     * 超时！
     * 
     */
    // public int trap3(int[] height) {
    //     int sum =0;
    //     int max = getMax(height);
    //     for(int i =1;i<=max;i++){
    //         boolean isStart = false;
    //         int temp_sum =0;
    //         for(int j=0;j<height.length;j++){
    //             if(isStart&&height[j]<i){
    //                 temp_sum++;
    //             }
    //             if(height[j]>=i){
    //                 sum +=temp_sum;
    //                 temp_sum =0;
    //                 isStart = true;
    //             }
    //         } 
    //     }
    //     return sum;
    // }

    // private int getMax(int[] height) {
    //     int max =0;
    //     for(int i=0;i<height.length;i++){
    //         if(height[i]>max){
    //             max = height[i];
    //         }
    //     }
    //     return max;
    // }


    /**
     * 方法4：双指针
     * 不从左和从右分开计算，我们想办法一次完成遍历。
     * 类比：快排
     *  假设一开始left-1大于right+1，则之后right会一直向左移动，直到right+1
     *  大于left-1.在这段时间内right所遍历的所有点都是左侧最高点maxleft
     * 大于右侧最高点maxright的，所以只需要根据原则判断maxright与当前高度的关系
     * 就行。反之left右移，所经过的点只要判断maxleft与当前高度的关系就行
     * @param height
     * @return
     */
    // public int trap4(int[] height) {
    //    int sum =0;
    //    int max_left =0;
    //    int max_right =0;
    //    int left =1;
    //    int right = height.length-2;
    //    for(int i=1;i<height.length-1;i++){
       
    //        if(height[left -1]<height[right+1]){
    //            max_left = Math.max(max_left,height[left-1]);
    //            int min = max_left;
    //            if(min>height[left]){
    //                sum+=min-height[left];
    //            }
    //            left++;
    //        }else{
    //            max_right = Math.max(max_right, height[right+1]);
    //            int min = max_right;
    //            if(min>height[right]){
    //                sum+=min-height[right];
    //            }
    //            right--;
    //        }
    //    }
    //    return sum;
    // }


    /**
     * 方法5：栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum =0;
        Stack<Integer> stack = new Stack<>();
        int current =0;
        while(current<height.length){
            while(!stack.empty()&&height[current]>height[stack.peek()]){
                int h = height[stack.peek()];
                stack.pop();
                if(stack.empty()){
                    break;
                }
                int distance = current-stack.peek()-1;
                int min = Math.min(height[stack.peek()],height[current]);
                sum+=distance*(min-h);
            }
            stack.push(current);
            current++;
        } 

       return sum;
     }
}
// @lc code=end

