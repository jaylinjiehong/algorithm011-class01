import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    /**
     * 递归的做法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        recursion("",0,digits,map,result);

        return result;
    }

    private void recursion(String str, int i, String digits, Map<Character, String> map, List<String> result) {
        // recursion terminator
        if(i==digits.length()){
            result.add(str);
            return;
        }
        // process logic in current level
        char key = digits.charAt(i);
        String value = map.get(key);
        // drill down
        for(int j=0;j<value.length();j++){
            recursion(str+value.charAt(j), i+1, digits, map, result);
        }
        // reverse the current level status if needed
        return;
    }
}
// @lc code=end

