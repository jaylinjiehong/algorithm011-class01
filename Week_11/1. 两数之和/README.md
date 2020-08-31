## [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

### c

-   c 语言指针真的很绕，需要多阅读代码，多了解标准库，才能更加熟悉!

```

struct hash_data{
    int key;
    int data;
    struct hash_data * next;
};

 struct hash_table
{
    struct hash_data ** head; //数组
    int hash_width;
};

///初始化
int hash_init(struct hash_table * table, int width){
    if(width<=0)
        return -1;
    struct hash_data **tmp = malloc(sizeof(struct hash_data *)*width);
    table->head = tmp;
    memset(table->head, 0, width * sizeof(struct hash_data *));
    if(table->head==NULL)
        return -1;
    table->hash_width = width;
    return 0;
}

///释放
void hash_free(struct hash_table table){
    if(table.head!=NULL){
        for (int i=0; i<table.hash_width; i++) {
            struct hash_data* element_head= table.head[i];
            while (element_head !=NULL) {
                struct hash_data* temp =element_head;
                element_head = element_head->next;
                free(temp);
            }
        }
        free(table.head);
        table.head = NULL;
    }
    table.hash_width = 0;
}

int hash_addr(struct hash_table table,int key){
    int addr =abs(key) % table.hash_width;
    return addr;
}

///增加
int hash_insert(struct hash_table table,int key, int value){
    struct hash_data * tmp = malloc(sizeof(struct hash_data));
    if(tmp == NULL)
        return -1;
    tmp->key = key;
    tmp->data = value;
    int k = hash_addr(table,key);
    tmp->next =table.head[k];
    table.head[k]=tmp;
    return 0;
}

///查找
struct hash_data* hash_find(struct hash_table table, int key){
    int k = hash_addr(table,key);
    struct hash_data* element_head=table.head[k];
    while (element_head !=NULL) {
        if ( element_head->key == key) {
            return element_head;
        }
        element_head = element_head->next;
    }
    return NULL;
}

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
      int* res = (int *)malloc(sizeof(int) * 2);
    * returnSize=0;
    struct hash_table table;
    hash_init(&table, 100);
    for(int i = 0; i < numsSize; i++)
    {
      int value = target - nums[i];
    struct hash_data* data=  hash_find(table, value);
        if (data !=NULL && data->data != i) {
            res[1]=i;
            res[0]=data->data;
            * returnSize=2;
            break;
        }
        hash_insert(table,nums[i] ,i);
    }
    hash_free(table);
    return res;
}

```

### cpp

-   c++的各种标准库也是很好用的工具，学习一门语言大概也就是学习记忆住其标准库生态吧！

```
/**
*一次哈希表法
*/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> a;
        vector<int> b(2,-1);
        for(int i=0;i<nums.size();i++){
            if(a.count(target-nums[i])>0){
                b[0] = a[target-nums[i]];
                b[1] =i;
                break;
            }
            a[nums[i]] = i;
        }
        return b;
    }
};

```

### golang

### java

-   [Class HashMap<K,V>](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)

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

-   [Web technology for developers/ JavaScript/ JavaScript reference/ Standard built-in objectsArray](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array)

-   [Web technology for developers/ JavaScript/ JavaScript reference/ Standard built-in objectsMap](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map)

```
var twoSum = function(nums, target) {
    const map = {};
    for (let i = 0; i < nums.length; i++) {
        const another = target - nums[i];
        if (another in map) {
            return [map[another], i];
        }
        map[nums[i]] = i;
    }
    return null;
};

```

#### 复杂度分析

-   时间复杂度：O(n)

-   空间复杂度：O(n)

### kotlin

-   [kotlin-stdlib / kotlin.collections / MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/)
-   [kotlin-stdlib / kotlin.collections / mutableMapOf](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-map-of.html)

-   [kotlin-stdlib / kotlin / IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/)

-   [kotlin-stdlib / kotlin / intArrayOf](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/int-array-of.html)

-   [Kotlin 中?和!!的区别](https://www.cnblogs.com/weizhxa/p/9982536.html)

```
class Solution {
    /**
     * 一遍哈希表法
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int,Int> = mutableMapOf()
        for(i in nums.indices){
            val other: Int = target - nums[i]
            if(map.containsKey(other)){
                return intArrayOf(map[other]!!,i)
            }
            map[nums[i]] = i
        }
        throw IllegalArgumentException("No two sum solution")
    }
}

```

### mysql

### python

### python3

### scala

### typeScript
