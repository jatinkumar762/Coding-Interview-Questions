https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1


#### Approach-1 Basic

```java
//User function Template for Java

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    
    int[] result = new int[queries];
    
    for(int i=0;i<queries;i++){
        int index = indices[i];
        int count = 0;
        for(int j = index+1;j<N;j++){
            if(arr[index] < arr[j]){
                count+=1;
            }
        }
        result[i] = count;
    }
    
    return result; 
  }
}
```

#### Approach-2 Optimized Approach -  Count Inversion(Merge Sort)

https://www.geeksforgeeks.org/number-nges-right/