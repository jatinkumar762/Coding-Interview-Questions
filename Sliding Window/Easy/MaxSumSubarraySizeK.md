https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3

```java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N) {
        // code here
        
        long maxSum = 0L;
        long sum = 0L;
        for(int i=0;i<K;i++){
            sum+=Arr.get(i);
        }
        maxSum = sum;
        
        for(int i=K;i<N;i++){
            sum+=Arr.get(i);
            sum-=Arr.get(i-K);
            
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum;
    }
}
```