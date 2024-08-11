https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/

```java
class Solution
{
    static int index;
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] inDegree = new int[V];
        int[] result = new int[V];
        index = 0;
        
        for(int i=0;i<V;i++){
            for(Integer next:adj.get(i)){
                inDegree[next]+=1;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            Integer vtx = queue.poll();
            result[index++] = vtx;
            for(Integer nbr: adj.get(vtx)){
                inDegree[nbr]-=1;
                if(inDegree[nbr]==0){
                    queue.add(nbr);
                }
            }
        }
        
        return result;
    } 
}
```