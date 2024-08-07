https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

#### Approach-1 Using Stack
```java
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(!visited[vertex]){
                visited[vertex] = true;
                result.add(vertex);
                //Push all adjacent vertices of the popped vertex into the stack
                //Reverse order to mimic recursion
                //bcz last pushed element will be on top of stack
                for(int i = adj.get(vertex).size()-1; i>=0 ; i--){ 
                    if(visited[adj.get(vertex).get(i)]==false){
                        stack.add(adj.get(vertex).get(i));
                    }
                }   
            }
        }
        return result;
    }
}

/*
while(!stack.isEmpty()){
    int vertex = stack.pop();
    
    if(!visited[vertex]){
        visited[vertex] = true;
        result.add(vertex);
        for(Integer n : adj.get(vertex)){
            if(visited[n]==false){
                stack.add(n);
            }
        }   
    }
}
*/
```

#### Approach-2 Using Recursion

```java
class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        dfs(adj, 0, visited);
        
        return result;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited){
        
        if(visited[node]){
            return;
        }
        
        visited[node] = true;
        
        result.add(node);
        
        for(int near : adj.get(node)){
            if(visited[near]==false){
                dfs(adj, near, visited);
            }
        } 
        
    }
}
```