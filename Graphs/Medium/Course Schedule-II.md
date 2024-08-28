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

        //using dfs will be difficult to detect loop
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