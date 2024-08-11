https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/

**Indegree Array:** Initially all elements are set to 0. Then, We will count the incoming edges for a node and store it in this array. For example, if indegree of node 3 is 2, indegree[3] = 2.

**Queue:** As we will use BFS, a queue is required. Initially, the node with indegree 0 will be pushed into the queue.

**Result array:** Initially empty and is used to store the linear ordering.

1. First, we will calculate the indegree of each node and store it in the indegree array. 
2. Initially, push the node(s) with indegree 0 into the queue.
3. Then, we will pop a node from the queue including the node in our result array, and for all its adjacent nodes, we will decrease the indegree of that node by one.
4. After that, if for any node the indegree becomes 0, we will push that node again into the queue.
5. We will repeat steps 3 and 4 until the queue is completely empty.
6. Finally, completing the BFS we will get the linear ordering of the nodes in the answer array.

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