import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    /**
     * bfs+剪枝
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        set.remove(beginWord);
        int step =1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String temp = queue.remove();
                char[] word = temp.toCharArray();
                for(int k=0;k<word.length;k++){
                    char before = word[k];
                    for(char j='a';j<'a'+26;j++){
                        word[k]=j;
                        String after = String.valueOf(word);
                        if(endWord.equals(after)){
                            return step+1;
                        }
                        if(j!=before&&set.contains(after)&&!visited.contains(after)){
                            queue.add(after);
                            visited.add(after);
                        }
                    }
                    word[k] = before;
                }
            }
            step++;
        }
        return 0;
    }
}
// @lc code=end

