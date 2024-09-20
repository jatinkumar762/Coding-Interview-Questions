https://www.geeksforgeeks.org/problems/geek-jump/1

#### Recursive Solution - TLE

```java
class Solution{
    
    public int calculateEnergy(int[] arr, int currIndex, int N){
        
        if(currIndex>=N-1){
            return 0;
        }
        
        int res1 = Integer.MAX_VALUE, res2 = Integer.MAX_VALUE;
        
        if(currIndex+1<=N-1){
            res1 = Math.abs(arr[currIndex] - arr[currIndex+1]) + calculateEnergy(arr, currIndex + 1, N);
        }
        
        if(currIndex+2<=N-1){
            res2 =  Math.abs(arr[currIndex] - arr[currIndex+2]) + calculateEnergy(arr, currIndex + 2, N);
        }
        
        return Math.min(res1, res2);
    }
    
    public int minimumEnergy(int arr[],int N){
        
        //code here
        
        return calculateEnergy(arr, 0, N);
    }
}
```