/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start
class Solution {
    /*
     * bfs
     * 从0号开始，统计已经遍历的个数，对比一下。
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        visited.add(0);
        while(!queue.isEmpty()){
            int room = queue.removeFirst();
            for(int item :  rooms.get(room)){
                if(!visited.contains(item)){
                    visited.add(item);
                    queue.offer(item);
                }
            }
        } 
        if(visited.size()==rooms.size()){
            return true;
        }else{
            return false;
        }
    }
}



// class Solution {
//     /**
//      * dfs
//      * 从0号开始，统计已经遍历的个数，对比一下。
//      */
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         Set<Integer> visited = new HashSet<>();
//         dfs(rooms,0,visited);
//         if(visited.size()==rooms.size()){
//             return true;
//         }else{
//             return false;
//         }
//     }

//     private void dfs(List<List<Integer>> rooms,int room,Set<Integer> visited){
//         if(visited.contains(room)){
//             return;
//         }
//         visited.add(room);
//         for(Integer next: rooms.get(room)){
//             dfs(rooms,next,visited);
//         }
//     }
// }
// @lc code=end

