https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

### Approach-1 Level Order Traversal + Map

* 5ms Beats 10.66%

```java
class Solution {

    static class Node {
        TreeNode root;
        int col;

        Node(TreeNode root, int col) {
            this.root = root;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));

        int count = 1;
        int newCount = 0;

        Map<Integer, List<Integer>> colToNodesMap = new TreeMap<>();

        while (!queue.isEmpty()) {

            Map<Integer, List<Integer>> levelColMap = new HashMap<>();

            for (int i = 0; i < count; i++) {

                Node tmp = queue.poll();

                if (!levelColMap.containsKey(tmp.col)) {
                    levelColMap.put(tmp.col, new ArrayList<>());
                }

                levelColMap.get(tmp.col).add(tmp.root.val);

                if (tmp.root.left != null) {
                    queue.add(new Node(tmp.root.left, tmp.col - 1));
                    newCount++;
                }

                if (tmp.root.right != null) {
                    queue.add(new Node(tmp.root.right, tmp.col + 1));
                    newCount++;
                }
            }

            levelColMap.forEach((key, value) -> {
                Collections.sort(value);

                if (!colToNodesMap.containsKey(key)) {
                    colToNodesMap.put(key, value);
                } else {
                    colToNodesMap.get(key).addAll(value);
                }
            });

            count = newCount;
            newCount = 0;
        }

        colToNodesMap.forEach((key, value) -> {
            result.add(value);
        });

        return result;
    }
}
```

### Approach-2 2ms Beats 99.70%

* reference - leetcode solutions

```java
class Solution {
    static class pair implements Comparable<pair> {
        TreeNode node;
        int row;
        int col;

        pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }

        public int compareTo(pair o) {
            if (this.col != o.col) {
                return this.col - o.col;
            } else if (this.row != o.row) {
                return this.row - o.row;
            }
            return this.node.val - o.node.val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<pair> q = new PriorityQueue<>();
        dfs(root, 0, 0, q);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> k = new ArrayList<>();
            int g = q.peek().col;
            while (!q.isEmpty() && q.peek().col == g) {
                pair curr = q.poll();
                k.add(curr.node.val);
            }
            ans.add(k);
        }
        return ans;
    }

    static void dfs(TreeNode node, int row, int col, PriorityQueue<pair> q) {
        if (node == null)
            return;
        pair newpair = new pair(node, row, col);
        q.add(newpair);
        dfs(node.left, row + 1, col - 1, q);
        dfs(node.right, row + 1, col + 1, q);

    }
}
```