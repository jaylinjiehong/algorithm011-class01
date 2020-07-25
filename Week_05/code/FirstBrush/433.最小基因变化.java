import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    /**
     * BFS
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if(bank.length==0){
            return -1;
        }
        Set<String> bankSet = new HashSet<>();
        for(String str:bank){
            bankSet.add(str);
        }
        if(!bankSet.contains(end)){
            return -1;
        }
        bankSet.remove(start);
        int step = 0;
        char[] allChars = {'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>(); 
        visited.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String temp = queue.poll();
                ArrayList<String> nextNodes = getNextNodes(temp, bankSet,visited,allChars);
                for(String nextNode:nextNodes){
                    if(nextNode.equals(end)){
                        return step+1;
                    }else{
                        queue.offer(nextNode);
                        visited.add(nextNode);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private ArrayList<String> getNextNodes(String temp, Set<String> bankSet, Set<String> visited, char[] allChars) {
        ArrayList<String> nextNodes = new ArrayList<>();
        char[] node  = temp.toCharArray();
        for(int i=0;i<node.length;i++){
            char oldChar = node[i];
            for(char c:allChars){
                node[i]=c;
                String newNode = String.valueOf(node);
                if(bankSet.contains(newNode)&&!visited.contains(newNode)){
                    nextNodes.add(newNode);
                }
            }
            node[i]=oldChar;
        }
        return nextNodes;
    }
  
}
// @lc code=end

