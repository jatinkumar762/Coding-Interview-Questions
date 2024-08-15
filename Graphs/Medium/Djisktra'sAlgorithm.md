https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

```java
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
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
        
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(nodeSort);
        minHeap.add(new Node(S, 0));
        dist[S] = 0;
        
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            for(ArrayList<Integer> nbr : adj.get(node.vertex)){
                if((node.dist + nbr.get(1)) < dist[nbr.get(0)]){
                 dist[nbr.get(0)] = node.dist + nbr.get(1);
                 minHeap.add(new Node(nbr.get(0), dist[nbr.get(0)]));
                }
            }
        }
        
        return dist;
    }
}
```