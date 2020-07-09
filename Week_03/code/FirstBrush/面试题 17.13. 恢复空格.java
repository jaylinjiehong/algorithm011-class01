import java.util.Arrays;

/**
 * @author ljh
 */
public class Solution {
    /**
     * 1、Trie+动态规划
     * 结合图解+代码理解=真巧妙啊！
     * 
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        //构造Trie树
        Trie root = new Trie();
        for (String word : dictionary) {
            root.insert(word);
        }

        //
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            // dp[i]记录目前未使用的字符的最小值
            dp[i] = dp[i-1]+1;

        //这里的root中的Trie[] next数组下标映射保存的是
        // 所有dictionary单词的最后一个字符
          Trie curPos = root;
           //遍历每个字符，判断是否有以这个字符结尾的单词存在，
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    //取剩下字符的最小值
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                //类似dfs遍历到叶子节点
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }
}

/**
 * 字典树
 * 能够让我们快速知道以某个字符开头的单词是否在dictionary中
 */
class Trie {
    public Trie[] next;
    public boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String s) {
        Trie curPos = this;

        for (int i = s.length() - 1; i >= 0; --i) {
            int t = s.charAt(i) - 'a';
            if (curPos.next[t] == null) {
                curPos.next[t] = new Trie();
            }
            curPos = curPos.next[t];
        }
        curPos.isEnd = true;
    }
}

// class Solution {
//     static final long P = Integer.MAX_VALUE;
//     static final long BASE = 41;
//     /**
//     *用HashSet存储字典，对子串查字典
//     */
//     public int respace(String[] dictionary, String sentence) {
//         Set<Long> hashValues = new HashSet<Long>();
//         for (String word : dictionary) {
//             hashValues.add(getHash(word));
//         }

//         int[] f = new int[sentence.length() + 1];
//         Arrays.fill(f, sentence.length());

//         f[0] = 0;
//         for (int i = 1; i <= sentence.length(); ++i) {
//             f[i] = f[i - 1] + 1;
//             long hashValue = 0;
//             for (int j = i; j >= 1; --j) {
//                 int t = sentence.charAt(j - 1) - 'a' + 1;
//                 hashValue = (hashValue * BASE + t) % P;
//                 if (hashValues.contains(hashValue)) {
//                     f[i] = Math.min(f[i], f[j - 1]);
//                 }
//             }
//         }

//         return f[sentence.length()];
//     }

//     public long getHash(String s) {
//         long hashValue = 0;
//         for (int i = s.length() - 1; i >= 0; --i) {
//             hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
//         }
//         return hashValue;
//     }
// }