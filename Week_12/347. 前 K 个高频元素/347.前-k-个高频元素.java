/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    /**
     * 优先队列，小顶堆，存k个数。
     * map存key=数，value=数的个数
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue( new Comparator<Integer>() {
	        @Override
	        public int compare(Integer a, Integer b) {
		        // 优先队列默认是最小堆，因为我们是map里面的value来决定大小，因此需要重新定义比较的规则
		        return map.get(a)-map.get(b); 
	        }
        });


        for(Integer key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else if(map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        int[] res = new int[k];
        int count =0;
        while(!pq.isEmpty()){
            res[count++] = pq.remove();
        }
        return res;
    }
}
// @lc code=end

