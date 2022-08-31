[Problem](https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1)

#### Method-1: Precalculation - O(N)

```java
class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        int[] leftMax = new int[n];
        leftMax[0] = leftMax[n-1] = -1;
        
        int[] rightMax = new int[n];
        rightMax[0] = rightMax[n-1] = -1;
        
        int max = arr[0];
        for(int i=1;i<n-1;i++){
            if(arr[i]>max){
               leftMax[i] = -1;
               max = arr[i];
            }
            else
               leftMax[i] = max;
        }
        
        max = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>max){
               rightMax[i] = -1;
               max = arr[i];
            }
            else
               rightMax[i] = max;
        }
        
        long res = 0L;
        for(int i=1;i<n-1;i++){
            if(leftMax[i]!=-1 && rightMax[i]!=-1){
                int maxLRHeight = leftMax[i]<rightMax[i]?leftMax[i]:rightMax[i];
                res += maxLRHeight - arr[i];
            }
        }
        return res;
    } 
}
```

#### Method-2: Using Stack
