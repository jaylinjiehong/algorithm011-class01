## [841. 钥匙和房间](https://leetcode-cn.com/problems/keys-and-rooms/)

### c

### cpp

### golang

### java

#### 复杂度分析

-   时间复杂度：O(n+m)

    -   其中 n 是房间的数量，m 是所有房间中的钥匙数量的总数。

-   空间复杂度：O(n)

    -   其中 n 是房间的数量。主要为栈空间的开销。

```
class Solution {
    /**
     * dfs
     * 从0号开始，统计已经遍历的个数，对比一下。
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms,0,visited);
        if(visited.size()==rooms.size()){
            return true;
        }else{
            return false;
        }
    }

    private void dfs(List<List<Integer>> rooms,int room,Set<Integer> visited){
        if(visited.contains(room)){
            return;
        }
        visited.add(room);
        for(Integer next: rooms.get(room)){
            dfs(rooms,next,visited);
        }
    }
}
```

```
class Solution {
    /*
     * bfs
     * 从0号开始，统计已经遍历的个数，对比一下。
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int room = queue.removeFirst();
                if(!visited.contains(room)){
                    visited.add(room);
                    for(Integer tempRoom: rooms.get(room)){
                        queue.addLast(tempRoom);
                    }
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
```

### javaScript

-

### kotlin

### mysql

### python

### python3

### scala

### typeScript
