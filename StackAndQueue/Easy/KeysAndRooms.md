[Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)

```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited, false);
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        visited[0] = true;
        for(Integer r:rooms.get(0))
            queue.add(r);
        
        while(queue.size()>0){
            int r = queue.poll();
            if(visited[r]==false){
                visited[r] = true;
                for(Integer no:rooms.get(r))
                    queue.add(no);
            }
        }
        for(boolean v : visited){
            if(!v)
                return false;
        }
        return true;
    }
}
```