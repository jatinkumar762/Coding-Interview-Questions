https://leetcode.com/problems/course-schedule/description/

#### Approach-1 Using BFS (Kahn)

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

        //using dfs will be difficult to detect loop

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