import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    /**
     * 哈希查表。
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
     int ans =0,direction=0,x=0,y=0;
     int[][] directions ={{0,1},{1,0},{0,-1},{-1,0}};

     HashSet<String> set = new HashSet<>();
     for(int[] arr:obstacles){
         set.add(arr[0]+","+arr[1]);
     }
     for(int com:commands){
         int nextX=0,nextY=0;
         if(com>0){
            for(int i=0;i<com;i++){
                nextX =x+directions[direction][0];
                nextY = y+directions[direction][1];
                if(set.contains(nextX+","+nextY)){
                    break;
                }
                x = nextX;
                y = nextY;
                ans = Math.max(ans, x*x+y*y);
                
            }
         }else{
             direction = com ==-1?(direction+1)%4:(direction+3)%4;
         }
     }
     return ans;
    }
}
// @lc code=end

