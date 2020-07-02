import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 * 1\模拟法
 * 2、字符串拼接法
 * 3、散列查表法
 */

// @lc code=start
class Solution {
    private static Map<Integer, String> divideMap;
    static {
        divideMap = new HashMap<>();
        divideMap.put(3, "Fizz");
        divideMap.put(5, "Buzz");
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String tempStr = "";
            for (Integer tempInt : divideMap.keySet()) {
                if (i % tempInt == 0) {
                    tempStr += divideMap.get(tempInt);
                }
            }
            if ("".equals(tempStr)) {
                tempStr += i;
            }
            result.add(tempStr);
        }
        return result;
    }
}
// @lc code=end
