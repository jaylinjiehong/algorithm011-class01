import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
/**
 * 数据结构是：哈希表+双向链表 约定：head后面存储最近最多使用的节点 tail前面存储最近最少使用的节点
 */
class LRUCache {
    class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode back;

        DLinkNode() {
        }
    }

    private Map<Integer, DLinkNode> map = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkNode head;
    private DLinkNode tail;

    /**
     * 初始化双向链表和哈希表
     * 
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.pre = null;
        tail.back = null;
        head.back = tail;
        tail.pre = head;
    }

    /**
     * map有：把元素移到双向队列的head的后面，返回元素 map没有：返回-1
     * 
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    /**
     * 1、是否超量？ map有 map没有
     * 
     * 
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (count == capacity) {
            if (map.containsKey(key)) {
                DLinkNode node = map.get(key);
                moveToHead(node);
                node.value = value;
            } else {
                // 删除tail节点的前一个
                map.remove(tail.pre.key);
                removeNode(tail.pre);
                count--;
                addNewNode(key, value);
                count++;
            }
        } else {
            if (map.containsKey(key)) {
                DLinkNode node = map.get(key);
                moveToHead(node);
                node.value = value;
            } else {
                addNewNode(key, value);
                count++;
            }
        }

    }

    /**
     * 把节点从原来的位置移动到head的后面
     * 
     * @param node
     */
    private void moveToHead(DLinkNode node) {
        // 把节点拿出来
        removeNode(node);

        // 把节点插入到head后面
        addNode(node);
    }

    /**
     * 双向队列拿出一个节点
     * 
     * @param node
     */
    private void removeNode(DLinkNode node) {
        DLinkNode preNode = node.pre;
        DLinkNode backNode = node.back;
        preNode.back = backNode;
        backNode.pre = preNode;
    }

    /**
     * 把节点插入到head节点后面
     * 
     * @param node
     */
    private void addNode(DLinkNode node) {
        node.back = head.back;
        head.back.pre = node;
        head.back = node;
        node.pre = head;
    }

    /**
     * cache增加新的节点，哈希表和双向队列一起更新
     * 
     * @param key
     * @param value
     */
    private void addNewNode(int key, int value) {
        DLinkNode newNode = new DLinkNode();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
