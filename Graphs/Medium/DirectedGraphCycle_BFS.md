https://www.geeksforgeeks.org/detect-cycle-in-a-directed-graph-using-bfs/

```java
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(Integer nbr:adj.get(i)){
                inDegree[nbr]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Integer vertex = queue.poll();
            result.add(vertex);
            for(Integer nbr : adj.get(vertex)){
                inDegree[nbr]-=1;
                if(inDegree[nbr]==0){
                    queue.add(nbr);
                }
            }
        }
        
        return !(result.size()==V);
    }
}
```