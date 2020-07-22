import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
     * BFS:通过队列实现
     * 
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> worSet = new HashSet<>(wordList);
        if (worSet.size() == 0 || (!worSet.contains(endWord))) {
            return 0;
        }
        worSet.remove(beginWord);
        

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] tempString = queue.poll().toCharArray();
                for (int k = 0; k < tempString.length; k++) {
                    char tempChar = tempString[k];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == tempChar) {
                            continue;
                        }
                        tempString[k] = j;
                        String nextWord = String.valueOf(tempString);
                        if (worSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }

                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    tempString[k] = tempChar;
                }

            }
            step++;
        }
        return 0;
    }
}
// @lc code=end
