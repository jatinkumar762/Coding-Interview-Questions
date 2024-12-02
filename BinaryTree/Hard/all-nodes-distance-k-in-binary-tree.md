https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

* first step in this problem is we need to convert binary tree to undirected graph
* because we want to maintain relation with parent, which not possible in binary tree
* once we build the graph, we can do bfs or dfs traversal from the target node

### Approach-1 Using BFS

```java
class Solution {

    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        buildGraph(root, null);

        List<Integer> result = new ArrayList<>();

        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);

        int count = 1, nextCount = 0;
        int dist = 0;

        while (!queue.isEmpty()) {

            if (dist == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                break;
            }

            for (int i = 0; i < count; i++) {

                TreeNode current = queue.poll();

                for (TreeNode neighbour : graph.get(current)) {

                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                        nextCount += 1;
                    }
                }
            }

            count = nextCount;
            nextCount = 0;

            dist += 1;
        }

        return result;
    }

    private void buildGraph(TreeNode root, TreeNode parent) {

        if (root == null) {
            return;
        }

        graph.putIfAbsent(root, new ArrayList<>());

        if (parent != null) {
            graph.get(root).add(parent);
            graph.get(parent).add(root);
        }

        /*
         * if(root.left!=null){
         * graph.get(root).add(root.left);
         * buildGraph(root.left, root);
         * }
         * if(root.right!=null){
         * graph.get(root).add(root.right);
         * buildGraph(root.right, root);
         * }
         */

        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }
}
```


**Time Complexity:**

* Build Graph will take $O(N)$ time, bcz visited each node once
* BFS search, the time complexity is O(V+E) &rarr; Each node is added to the queue and popped from the queue once, it takes O(n) to handle all nodes.

**Space Complexity:**

* We use a hash map graph to store all edges, which requires O(n) space for n−1 edges.
* hash set to record the visited nodes, which takes O(n) space.
* up to n nodes stored in queue and O(n) space is required.
* total is $O(n)$


### Approach-2 Using DFS