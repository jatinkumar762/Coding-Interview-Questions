https://leetcode.com/problems/is-graph-bipartite/description/

How to identify Bipartite Graph?
To identify whether a given graph is bipartite, you can use the following algorithm:

1. Choose any vertex in the graph and assign it to one of the two sets, say X.
2. Assign all of its neighbors to the other set, say Y.
3. For each vertex in set Y, assign its neighbors to set X, and for each vertex in set X, assign its neighbors to set Y.
4. Repeat step 3 until all vertices have been assigned to a set.
5. Check if any two adjacent vertices are in the same set. If yes, then the graph is not bipartite. Otherwise, it is bipartite.


#### Approach-1 Using BFS

```java
class Node {
    int v;
    Character flag;

    Node(int v, Character flag) {
        this.v = v;
        this.flag = flag;
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {

        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        //isolated vertex can be possible
        //[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
        for (int v = 0; v < graph.length; v++) {

            if (!visited[v]) {

                setX.add(v);
                visited[v] = true;
                queue.add(new Node(v, 'X'));

                while (queue.size() > 0) {

                    Node node = queue.poll();
                    Character nextFlag = (node.flag == 'X') ? 'Y' : 'X';
                    int vertex = node.v;

                    for (int i = 0; i < graph[vertex].length; i++) {

                        if (!visited[graph[vertex][i]]) {
                            queue.add(new Node(graph[vertex][i], nextFlag));
                            visited[graph[vertex][i]] = true;
                            if (nextFlag == 'Y') {
                                setY.add(graph[vertex][i]);
                            } else {
                                setX.add(graph[vertex][i]);
                            }
                        } else {
                            if (nextFlag == 'X' && setY.contains(graph[vertex][i])) {
                                return false;
                            } else if (nextFlag == 'Y' && setX.contains(graph[vertex][i])) {
                                return false;
                            }
                        }
                    }

                }
            }
        }

        return true;
    }
}
```


#### More Short code

```java
class Solution {
    public boolean isBipartite(int[][] graph) {

        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[graph.length];

        //isolated vertex can be possible
        //[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
        for (int v = 0; v < graph.length; v++) {

            if (color[v]==0) {

                queue.add(v);
                color[v] = 1;   // GroupA: 1; GroupB: -1.

                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int next : graph[curr]) {
                        if (color[next]==0) { //means node is not visited
                            queue.add(next);
                            color[next] = -1*color[curr]; // Color it with a different color;
                        } else if(color[next]!=-color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
```