import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */
/**
 * 1、我的哈希法
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> wordDict = new HashMap<>();
        char[] allChars = s.toCharArray();
        for(char temp : allChars){
            if(wordDict.containsKey(temp)){
                wordDict.put(temp,wordDict.get(temp)+1);
            }else{
                wordDict.put(temp,1);
            }
        }
        allChars = t.toCharArray();
        for(char temp : allChars){
            if(wordDict.containsKey(temp)&&wordDict.get(temp)!=0){
                wordDict.put(temp, wordDict.get(temp)-1);
            }else{
                return false;
            }

        }
        return true;

    }
}
// @lc code=end

