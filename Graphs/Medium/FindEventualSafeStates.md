https://leetcode.com/problems/find-eventual-safe-states/description/

#### Approach

* those vertex who part of loop, will not be safe nodes
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


