https://www.geeksforgeeks.org/problems/shortest-job-first/1

```java
class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int N = bt.length;
        
        //for first job, wait time will be zero
        int waitTime = 0;
        int sum = bt[0];

        for(int i=1;i<N;i++){
            //wait time will add sum of till N-2 elements ->Nth job wait time
            waitTime = waitTime + sum; 
            sum = sum+bt[i]; 
        }
        
        return waitTime/N;
    }
}
```