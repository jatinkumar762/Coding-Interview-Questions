https://leetcode.com/problems/course-schedule-ii/description/

#### Approach-1 Using BFS (Kahn)

```java
class Solution {

    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
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

        int[] result = new int[numCourses];
        int count=0; 



        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
                result[count++] = i;
                //will be included in result
            }
        }

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(int nbr : adj.get(vertex)){
                inDegree[nbr]-=1;
                if(inDegree[nbr]==0){
                    queue.add(nbr);
                    result[count++] = nbr;
                }
            }
        }

        if(count==numCourses){
            return result;
        } else {
            return new int[]{};
        }
    }
}
```

#### Approach-2 DFS Solution

```java
class Solution {

    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;
    boolean[] recStack;
    int[] result;
    int count;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        

        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        result = new int[numCourses];
        count = numCourses-1;

        adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            //edge b -> a
            adj.get(b).add(a);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i)){
                    return new int[]{}; //loop exist
                    //means topo sort wont be possible
                }
            }
        }

        //if no loop
        return result; 
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
        result[count--] = vertex;

        return false;
    }
}
```