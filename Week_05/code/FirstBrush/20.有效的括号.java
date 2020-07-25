import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    /**
     * 栈的使用
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character,Character> dict = new HashMap<>();
        dict.put(')','(');
        dict.put('}','{');
        dict.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char temp =s.charAt(i);
            if(dict.containsKey(temp)){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()==dict.get(temp)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(temp);
            } 
        }
        return stack.isEmpty();
    }
}
// @lc code=end

