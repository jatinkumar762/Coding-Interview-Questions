https://leetcode.com/problems/number-of-operations-to-make-network-connected/

* Hint: As long as there are at least (n - 1) connections, there is definitely a way to connect all computers.

#### Approach-1 Disjoint Set Union method 

```java
class Solution {

    private int[] parent;
    private int[] size;

    private int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private boolean union(int v1, int v2) {
        int pV1 = find(v1);
        int pV2 = find(v2);

        if (pV1 == pV2) {
            return false;
        }

        if (size[pV1] >= size[pV2]) {
            parent[pV2] = pV1;
            size[pV1] += size[pV2];
        } else {
            parent[pV1] = pV2;
            size[pV2] += size[pV1];
        }
        return true;
    }

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int edges = connections.length;
        int extraEdge = 0;
        for (int e = 0; e < edges; e++) {
            if (!union(connections[e][0], connections[e][1])) {
                // will create loop
                extraEdge += 1;
            }
        }

        for(int i=0;i<n;i++){
            find(i);
        }   

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(parent[i]);
        }

        int component = set.size();
        if(component-1 > extraEdge){
            return -1;
        }
        return component-1;
    }
}
```
