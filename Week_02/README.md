# [第二周学习笔记](https://www.yuque.com/docs/share/df75e869-3cbe-4ae1-9656-166190adff98?#)

## 视频内容
### 第5课 | 哈希表、映射、集合
![](https://cdn.nlark.com/yuque/0/2020/svg/205732/1593962132786-6ed2c869-cbae-4d60-a06a-450a98df9193.svg)

### 第6课 | 树、二叉树、二叉搜素树、堆、二叉堆、图
![](https://cdn.nlark.com/yuque/0/2020/svg/205732/1593962132851-ce056377-4079-47c7-ab3b-b42b69a86999.svg)

```java
//二叉树代码
public class TreeNode{
    public int val;
    public TreeNode left,right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```


```python
//二叉树代码
class TreeNode:
    def __init__(self,val):
        self.val = val
        self.left,self.right = None,None
```
```python
//二叉树代码
struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x),left(NULL),right(NULL){}
```
```python
//二叉树遍历示例代码
def preorder(self,root):
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)
def inorder(self,root):
    if root:
        self.inorder(root.left)
        self.traverse_path.append(root.val)
        self.inorder(root.right)
    
def postorder(self,root):
    if root:
        self.postorder(root.right)
        self.postorder(root.right)
        self.traverse_path.append(root.val)
```
```python
//DFS 代码-递归写法
visited = set() #和树中的DFS最大区别
def dfs(node,visited):
    if node in visited: #terminator
        #already visited
        return
    visited.add(node)
    
    #process current node here
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node,visited)
            
```
```python
//BFS 代码
def BFS(graph,start,end)0:
    queue[]
    queue.append([start])
    
    visited = set()#和树中BFS的最大区别
    
    while queue:
        node = queue.pop()
        visited.add(node)
        
        process(node)
        node = generate_related_nodes(node)
        queue.push(nodes)
```


## 作业
### HashMap小总结
![](https://cdn.nlark.com/yuque/0/2020/svg/205732/1593962132852-5f58c2b5-b499-4fc4-8a58-cb324bbf45ff.svg)

![](https://cdn.nlark.com/yuque/0/2020/gif/205732/1593871809403-fee4f4c2-cb82-49e0-977e-f65cff9114bd.gif#align=left&display=inline&height=611&margin=%5Bobject%20Object%5D&originHeight=611&originWidth=643&size=0&status=done&style=none&width=643)


### HeapSort
![](https://cdn.nlark.com/yuque/0/2020/svg/205732/1593962132860-916dc264-e484-4653-acba-61a3ac45b801.svg)

```java
/**
 * 二叉堆的实现 二叉堆中的数组下标为0的位置不存放数据 数组中下标为i的节点的左子节点：i*2
 * 右子节点为：i*2+1 父节点就是下标为i/2的节点
 */
public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 往堆中插入新元素
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        a[++count] = data;
        int i = count;
        int tem2p = i / 2;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            int temp = a[i];
            a[i] = a[i / 2];
            a[i / 2] = temp;
            i = i / 2;
        }
    }

    /**
     * 删除堆顶元素，自上往下堆化
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 遍历非叶子节点
     *
     * @param a
     * @param n
     */
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 保证非叶子节点大于左右子节点
     *
     * @param a
     * @param n
     * @param i
     */
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 堆排序
     *
     * @param a
     * @param n
     */
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    /**
     * 交换数组中2个元素
     *
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] test = new int[]{0, 2, 6, 4, 8, 1, 9};
        int[] test1 = new int[]{0,2, 6, 4, 8, 1, 9};
        int[] test2 = new int[]{0, 2, 6, 4, 8, 1, 9};
        Heap heap = new Heap(test1.length-1);
        for (int i = 1; i < test1.length; i++) {
            heap.insert(test1[i]);
        }
        System.out.println("通过插入：从下往上堆化");
        //从下往上的堆化方法
        for (int i : heap.a) {
            System.out.print(" " + i);
        }
        System.out.println();
        //删除堆顶元素
        heap.removeMax();
        System.out.println("删除堆顶元素：从上往下堆化");
        for (int i=0;i<=heap.count;i++) {
            System.out.print(" " + heap.a[i]);
        }
        System.out.println();
        System.out.println("原数组建堆：从上往下堆化");
        //从上往下的堆化方法
        Heap.buildHeap(test, test.length - 1);
        for (int i : test) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println("进行堆排序");
        //堆排序
        Heap.sort(test2, test2.length - 1);
        for (int i : test2) {
            System.out.print(" " + i);
        }
    }
}
        
```


### Leetcode题目

- [x] 242. 有效的字母异位词
- [x] 1. 两数之和
- [x] 589. N叉树的前序遍历
- [x] 49. 字母异位词分组
- [ ] 94. 二叉树的中序遍历
- [ ] 144. 二叉树的前序遍历
- [ ] 429. N叉树的层序遍历
- [ ] 剑指 Offer 49. 丑数
- [ ] 347. 前 K 个高频元素



### 关于如何刷题

- [🗓 每日一刷](https://www.yuque.com/docs/share/f85c3c8a-6cf6-48b8-9981-ca8e459b2628?#)
