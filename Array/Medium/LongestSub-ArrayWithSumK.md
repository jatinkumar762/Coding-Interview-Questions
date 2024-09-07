https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

#### Prefix-sum

```java
class Solution{
    
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        int longest = 0;
        
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        
        int sum=0;
        for(int i=0;i<N;i++) {
            sum+=A[i];
            
            if(sum == K){
                longest = i+1; 
            }
            else if(sumIndexMap.containsKey(sum-K)){
                longest = Math.max(longest, i-sumIndexMap.get(sum-K));
            }
            
            if(!sumIndexMap.containsKey(sum)) { 
                sumIndexMap.put(sum, i); 
            }
            
        }
        return longest;
    }
}
```