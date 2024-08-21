https://www.geeksforgeeks.org/problems/disjoint-set-union-find/1

**Implementation of the Disjoint Set Union with both Union by Rank and Path Compression**

```java
class DisjointSetUnion {
    private int[] parent;
    private int[] rank;

    // Constructor: initializes the DSU with n elements
    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Each element is its own parent initially
            rank[i] = 0;    // All trees have rank 0 initially
        }
    }

    // Find operation with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }

    // Union operation with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;  // Attach the smaller tree under the larger tree
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;  // Arbitrarily choose one as the new root
                rank[rootX]++;          // Increase the rank of the new root
            }
        }
    }
}
```

**Example Usage**

```java
public class Main {
    public static void main(String[] args) {
        DisjointSetUnion dsu = new DisjointSetUnion(5);

        // Initially, all elements are in their own set
        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(3, 4);

        // Find representatives of different sets
        System.out.println(dsu.find(0)); // Output: 0 or 1
        System.out.println(dsu.find(1)); // Output: 0 or 1
        System.out.println(dsu.find(2)); // Output: 2 or 3 or 4
        System.out.println(dsu.find(4)); // Output: 2 or 3 or 4

        // Union of the two sets {0,1} and {2,3,4}
        dsu.union(1, 3);

        // Now all elements should be in the same set
        System.out.println(dsu.find(0)); // Output: All should have the same root
        System.out.println(dsu.find(4)); // Output: All should have the same root
    }
}
```

**TimeComplexity:** 

* both find and union operations running in nearly constant time, specifically O(α(n)), where 𝛼 is the inverse Ackermann function, which grows very slowly.

