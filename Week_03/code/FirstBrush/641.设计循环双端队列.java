/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    int[] deque ;
    int size;
    int head,tail;
    int count;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size=k;
        deque = new int[k];

    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(count==size){
            return false;
        }else{
            if(count!=0){
                head = (head-1+size)%size;
            }
            deque[head]=value;
            count++;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count==size){
            return false;
        }else{
            if(count!=0){
                tail = (tail+1)%size;
            }
            deque[tail]=value;
            count++;
            return true;
        }

    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count==0){
            return false;
        }else{
            head=(head+1)%size;
            count--;
            if(count==0){
                tail=head;
            }
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count==0){
            return false;
        }else{
            tail = (tail-1+size)%size;
            count--;
            if(count==0){
                head=tail;
            }
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(count==0){
           return -1;
        }else{
            return deque[head];
        }

    }
    
 
   /** Get the last item from the deque. */
    public int getRear() {
        if(count==0){
            return -1;
        }else{
            return deque[tail];
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count==0?true:false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count==size?true:false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

