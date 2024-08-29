https://leetcode.com/problems/find-eventual-safe-states/description/

https://www.geeksforgeeks.org/problems/eventual-safe-states/0

#### Approach

* those vertex who are part of loop, will not be safe nodes
* those vertex who has path to unsafe node, will not be safe nodes


#### Approach-1 DFS Solution - 4ms Beats 99.10%

```java
class Solution {
    boolean[] visited;
    boolean[] path;
    int N;
    boolean[] result;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        N = graph.length;
        visited = new boolean[N];
        path = new boolean[N];
        result = new boolean[N];

        for(int i=0;i<N;i++){
            if(!visited[i]){
                DFS(i, graph);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(result[i]){
                res.add(i);
            }
        }

        return res;
    }

    boolean DFS(int vertex, int[][] graph){

        if(visited[vertex] && path[vertex]){
            return true;
            //means part of the loop
            //not part of safe node
        }

        if(visited[vertex] && !result[vertex]){
            return true;
            //reaching to unsafe node
        }

        if(visited[vertex]){
            return false;
        }

        visited[vertex] = true;
        path[vertex] = true;

        for(int nbr : graph[vertex]){
            //System.out.println(nbr);
            if(DFS(nbr, graph)){
                path[vertex] = false;
                result[vertex] = false;
                return true;
            }
        }

        path[vertex] = false;
        result[vertex] = true;

        return false;
    }
}
```

**Example 1:**
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.


**Example 2:**
Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.


