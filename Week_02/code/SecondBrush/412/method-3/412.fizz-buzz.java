import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sun.tools.tree.DivideExpression;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 * 散列表
 */

// @lc code=start
class Solution {
    private static HashMap<Integer,String> divideMap;
    static{
        divideMap = new HashMap<>();
        divideMap.put(3, "Fizz");
        divideMap.put(5, "Buzz");
    }
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        String tempStr = "";
        for(int i = 1; i <= n; i++){
            for(Integer key: divideMap.keySet()){
                if(i % key ==0){
                    tempStr += divideMap.get(key);
                }
            }
            if("".equals(tempStr)){
                tempStr +=i;
            }
            result.add(tempStr);
            tempStr = "";
        }

        return result;
    }
}
// @lc code=end

