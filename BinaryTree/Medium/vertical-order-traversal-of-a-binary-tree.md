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