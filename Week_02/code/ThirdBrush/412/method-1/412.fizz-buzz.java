import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 * 1、模拟法
 * 2、字符串拼接法
 * 3、
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();
        int divideBy3, divideBy5;
        for (int i = 1; i <= n; i++) {
            divideBy3 = i % 3;
            divideBy5 = i % 5;
            if (divideBy3 == 0 && divideBy5 == 0) {
                result.add("FizzBuzz");
                continue;
            }
            if (divideBy3 == 0) {
                result.add("Fizz");
                continue;
            }
            if (divideBy5 == 0) {
                result.add("Buzz");
                continue;
            }
            result.add(String.valueOf(i));
        }
        return result;
    }
}
// @lc code=end
