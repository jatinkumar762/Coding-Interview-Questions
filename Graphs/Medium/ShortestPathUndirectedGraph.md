https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

```java
class Node{
    int v;
    int dist;
    Node(int v, int dist){
        this.v = v;
        this.dist = dist;
    }
}

class Solution {

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath, -1);
        
        boolean[] visited = new boolean[n];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, 0));
        visited[src] = true;
        
        while(queue.size()>0){
            Node node = queue.poll();
            shortestPath[node.v] = node.dist;
            
            for(Integer nbr : adj.get(node.v)){
             if(!visited[nbr]){
                 visited[nbr] = true;
                queue.add(new Node(nbr, node.dist+1));
             }
            }
        }
        return shortestPath;
    }
}
```