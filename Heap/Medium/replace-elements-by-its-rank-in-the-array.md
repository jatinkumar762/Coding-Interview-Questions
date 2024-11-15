https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1


### Approach-1 Sorting + HashMap

```java
class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        
        if (N == 0) {
          return new int[] {};
        }

        int[] temp = arr.clone();
        
        Arrays.sort(temp);
        
        int rank[] = new int[N];
        
        rank[0] = 1;
        for(int i = 1; i<N; i++){
            if(temp[i] == temp[i-1]){
                rank[i] = rank[i-1];
            }
            else {
                rank[i] = rank[i-1] + 1;
            }
        }
        
        //System.out.println(Arrays.toString(rank));
        
        Map<Integer, Integer> eleToRanK = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            eleToRanK.put(temp[i], rank[i]);
        }
        
        int[] result = new int[N];
        
        for(int i = 0; i < N; i++){
            result[i] = eleToRanK.get(arr[i]);
        }
        
        return result;
    }
}
  
```