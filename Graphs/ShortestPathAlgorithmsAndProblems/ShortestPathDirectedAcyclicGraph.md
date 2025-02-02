https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

**Note: **

⚡ Correct Alternatives for Weighted DAGs:

1. Topological Sort + Relaxation (Optimal for DAGs): Linear time complexity O(V+E).

2. Dijkstra’s Algorithm: For general graphs with non-negative weights.

3. Bellman-Ford Algorithm: For graphs with negative weights (but handles cycles too).

**Test Case-**

6 7
0 1 2
0 4 1
4 5 4
4 2 2
1 2 3
2 3 6
5 3 1

**Output:** 0 2 3 6 1 5


### Approach-1 DFS (Similar to Topological Sort)

```java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int[] shortestPath = new int[N];
        Arrays.fill(shortestPath, -1);
        
        boolean[] visited = new boolean[N];
        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        
        for(int i=0;i<M;i++){
            ArrayList<Integer> tmp  = new ArrayList<>();
            tmp.add(edges[i][1]);
            tmp.add(edges[i][2]);
            adj.get(edges[i][0]).add(tmp);
        }
        
        dfs(0, adj, shortestPath, visited, 0);
        
        return shortestPath;
	}
	
	private void dfs(int source, ArrayList<ArrayList<ArrayList<Integer>>> adj, 
	int[] shortestPath, boolean[] visited, int dist){
	    
	    shortestPath[source] = dist;
	    
	    for(ArrayList<Integer> nbr : adj.get(source)){
	        if(shortestPath[nbr.get(0)]==-1  || (nbr.get(1)+dist < shortestPath[nbr.get(0)])){
	            dfs(nbr.get(0), adj, shortestPath, visited, nbr.get(1)+dist);
	        }
	    }
	}
	
	
}
```

* Dijkstra's algorithm is necessary for graphs that can contain cycles because they can't be topologically sorted. 

### Approach-2 Dijkstra’s Algorithm

```java

class Node{
    int vertex;
    int dist;
    
    Node(int vertex, int dist){
        this.vertex = vertex;
        this.dist = dist;
    }
}

//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int[] shortestPath = new int[N];
        Arrays.fill(shortestPath, -1);
        
        boolean[] visited = new boolean[N];
        
         // Write your code here
        Comparator<Node> nodeSort = new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                if(a.dist>b.dist){
                    return 1;
                }
                else if(a.dist==b.dist){
                    return 0;
                }
                return -1;
            } 
        };
        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        
        for(int i=0;i<M;i++){
            ArrayList<Integer> tmp  = new ArrayList<>();
            tmp.add(edges[i][1]);
            tmp.add(edges[i][2]);
            adj.get(edges[i][0]).add(tmp);
        }
        
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(nodeSort);
        minHeap.add(new Node(0, 0));
        shortestPath[0] = 0;
        
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            visited[node.vertex] = true;
            
            for(ArrayList<Integer> nbr : adj.get(node.vertex)){
                if(!visited[nbr.get(0)] && ( shortestPath[nbr.get(0)]==-1 || (node.dist + nbr.get(1)) < shortestPath[nbr.get(0)])){
                 shortestPath[nbr.get(0)] = node.dist + nbr.get(1);
                 minHeap.add(new Node(nbr.get(0), shortestPath[nbr.get(0)]));
                }
            }
        } 
        return shortestPath;
	}
}
```