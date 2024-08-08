https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

* need to take care of parent vertex

#### Approach-1 Using BFS

```java
class Node {
    int vertex;
    int parent;
    
    Node(int vertex, int parent){
        this.vertex = vertex;
        this.parent = parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        
        Queue<Node> queue = new LinkedList<>(); 
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                queue.add(new Node(i, -1));
                visited[i] = true;
                 
                while(queue.size()>0){
                    Node node = queue.poll();
                    for(int neighbour: adj.get(node.vertex)){
                        if(visited[neighbour]){
                         if(node.parent!=neighbour){
                            return true;
                         }
                        } else {
                            queue.add(new Node(neighbour, node.vertex));
                            visited[neighbour] = true;
                        }
                    }
                }
            }
        }
        
        
        return false;
    }
}
```

#### Approach-1 Using DFS

```java

```