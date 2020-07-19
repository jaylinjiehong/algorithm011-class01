## 第四周学习笔记
### 1、课后思考：使用二分查找，寻找一个半有序数组[4,5,6,7,0,1,2]中间无序的地方
+ 代码和思路如下
```
package com.company;

public class Main {
    /**
     * 1、考虑数组长度为0和1时，无序地方下标不存在，返回-1.
     * 2、开始进行二分搜索的左右边界初始化
     * 3、进行二分查找算法：目的是找出有序子数组，然后判断nums[mid]附近是否刚好是无序的地方
     * 3.1、若mid左边是有序子数组，则判断在nums[mid+1]合法的时候，nums[mid+1]是否小于nums[mid]。若是，则返回mid+1；若不是，则对mid右边子数组进行二分查找
     * 3.2、若mid右边是有序子数组，则判断nums[mid-1]合法的时候，nums[mid-1]是否大于nums[mid]。若是，则返回mid；若不是，则对mid左边子数组进行二分查找
     * 4、若不存在无序，则返回-1.
     *
     * @param nums
     * @return
     */
    public int findDisorder(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[0] <= nums[mid]) {
                if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                    return mid + 1;
                }
                left = mid + 1;
            } else {
                if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums0 = new int[0];
        System.out.println("数组[]中无序开始的地方的下标是：" + main.findDisorder(nums0));
        int[] nums1 = new int[]{1};
        System.out.println("数组[1]中无序开始的地方的下标是：" + main.findDisorder(nums1));
        int[] nums2 = new int[]{2, 1};
        System.out.println("数组[2,1]中无序开始的地方的下标是：" + main.findDisorder(nums2));
        int[] nums3 = new int[]{2, 3, 1};
        System.out.println("数组[2,3,1]中无序开始的地方的下标是：" + main.findDisorder(nums3));
        int[] nums4 = new int[]{3, 4, 1, 2};
        System.out.println("数组[3,4,1,2]中无序开始的地方的下标是：" + main.findDisorder(nums4));
        int[] nums5 = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println("数组[4,5,6,7,0,1,2]中无序开始的地方的下标是：" + main.findDisorder(nums5));
        int[] nums6 = new int[]{1, 2};
        System.out.println("数组[1,2]中无序开始的地方的下标是：" + main.findDisorder(nums6));
        int[] nums7 = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println("数组[0,1,2,3,4,5,6,7]中无序开始的地方的下标是：" + main.findDisorder(nums7));
    }
}
```

### 2、训练营课件的力扣题目

+ 个人把训练营的课件全部过了一遍，把里面的力扣题目给抽取出来，上学期共计67道，下学期共计68道，整个学期共计135道。放在语雀的一篇文章中，然后同时把相关联的代码片段以及相关知识上下文也关联在一起，因为脑图在平常用手机查看太不方便，所以后续通过补全这篇文章，可以达到脑图一样的效果，同时在上下班通勤的时候，也可以看一会。而且在积累非训练营力扣题目时，也可以补全在后面，采用一样的步骤进行。授之以鱼不如授之以渔！

+ [《训练营题目》](https://www.yuque.com/docs/share/a32afd57-a401-49be-84f4-d8c82f778788?#)

### 3、思维与方法巩固

+ 1）知识思维导图化【体系化】
+ 2）过遍数：首先全部得先过一遍，然后全部再过第二遍、第三遍...【重点是“全部”，不能死磕局部！】
+ 3）代码、代码模板以及数据结构和算法知识思维导图化，过遍数。
+ 4）知识迁移化：在上面使用五毒神掌把数据结构和算法掌握得很扎实的时候，可以对计算机基础知识、计算机网络、系统设计等与数据结构和算法扯到关系的，进行关联体系化，过遍数。

### 4、心态与行动
+ 有了方法论之后，就要放平心态，以小学生的谦逊之心，努力做题、积累、反馈，体系化，过遍数，做好时间管理。