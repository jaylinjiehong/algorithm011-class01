import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=412 lang=java
 * 1、模拟法
 * 2、字符串拼接法
 * 3、散列查表法
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String tempStr = "";
            if (i % 3 == 0) {
                tempStr += "Fizz";
            }
            if (i % 5 == 0) {
                tempStr += "Buzz";
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
