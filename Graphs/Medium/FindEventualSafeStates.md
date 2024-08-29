https://leetcode.com/problems/find-eventual-safe-states/description/

https://www.geeksforgeeks.org/problems/eventual-safe-states/0

#### Approach

* those vertex who are part of loop, will not be safe nodes
* those vertex who has path to unsafe node, will not be safe nodes

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

#### Approach-2 BFS Solution -> topo sort | 24ms

* Kahn algorithm, work based on indegree zero
* terminal node is outdegree zero
* just reverse the edges and follow same Kahn BFS approach
* sort the result, because it can be in any order

```java
class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int N = graph.length;
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[N];

        // reverse the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N; i++) {
            for (int nbr : graph[i]) {
                adj.get(nbr).add(i);
                inDegree[i] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int vertex = queue.poll();
            result.add(vertex);

            for (Integer nbr : adj.get(vertex)) {
                inDegree[nbr] -= 1;
                if (inDegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }

        }

        Collections.sort(result);

        return result;
    }

}
```



