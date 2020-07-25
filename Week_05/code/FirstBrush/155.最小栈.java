import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
/**
 * 关键在于审题：并不需要因为每次获取最小值改变所存数的顺序。
 * “以空间换时间，辅助栈是常见的做法”
 * 方法一：辅助栈和数据栈同步
 */
class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> helper;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        data.add(x);
        if(helper.isEmpty()||helper.peek()>=x){
            helper.add(x);
        }else{
            helper.add(helper.peek());
        }
    }
    
    public void pop() {
        if(!data.isEmpty()){
            helper.pop();
            data.pop();
        }

    }
    
    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");

    }
    
    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

