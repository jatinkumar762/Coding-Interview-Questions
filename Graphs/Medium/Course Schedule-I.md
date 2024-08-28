https://leetcode.com/problems/course-schedule/description/

#### Approach-1 Using BFS (Kahn) - slower than approach-2

```java
class Solution {

    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;
    int count;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];

        adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            //edge b -> a
            adj.get(b).add(a);
            inDegree[a]+=1;
        }

        count = 0;

        //using toposort dfs will be difficult to detect loop

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
                count+=1; //will be included in result
            }
        }

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(int nbr : adj.get(vertex)){
                inDegree[nbr]-=1;
                if(inDegree[nbr]==0){
                    queue.add(nbr);
                    count+=1;
                }
            }
        }

        return count==numCourses; 
    }
}
```

#### Approach-2 Using DFS -> faster than BFS by 2ms

* if there is loop -> means not possible, otherwise possible
* we need to detect loop in directed graph

```java
class Solution {

    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;
    boolean[] recStack;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];

        adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            //edge b -> a
            adj.get(b).add(a);
            inDegree[a]+=1;
        }

        //using dfs will be difficult to detect loop

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i)){
                    return false; //loop exist
                    //means topo sort wont be possible
                }
            }
        }

        //if no loop
        return true; 
    }

    boolean dfs(int vertex){

        //loop present
        if(visited[vertex] && recStack[vertex]){
            return true;
        }

        if(visited[vertex]){
            return false;
        }

        visited[vertex] = true;
        recStack[vertex] = true;

        for(int nbr : adj.get(vertex)){
            if(dfs(nbr)){
                return true;
            }
        }

        recStack[vertex] = false;
        return false;
    }

}
```