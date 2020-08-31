## [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

### bash

### c

### cpp

### golang

### java

-   一遍哈希表法是最好的，比两遍哈希表法好一点。

#### 复杂度分析

-   时间复杂度：O(n)

    -   遍历了包含 n 个元素的列表一次。在表中进行的每次查找只花费 O(1)的时间。

-   空间复杂度：O(n)

    -   所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。

```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{i,map.get(temp)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

### javaScript

### kotlin

### mysql

### python

### python3

### scala

### typeScript
