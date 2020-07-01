import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 * 字符串拼接法
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        String tempStr = "";
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0){
                tempStr += "Fizz";
            }
    
            if(i % 5 == 0){
                tempStr += "Buzz";
            }

            if("".equals(tempStr)){
                tempStr += i;
            }
            
            result.add(tempStr);
            tempStr = "";
        }
        return result;
    }
}
// @lc code=end

