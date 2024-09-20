https://www.geeksforgeeks.org/problems/introduction-to-dp/1

**Problem:** $nth$ Fibonacci number.

```java
class Solution {
    //0 1 1 2 3 5
    static long[] res;
    
    static int modulo = 1000000007;
    
    static long topDownApproach(int n){
        
        if(n<=1){
            return n;
        }
        
        if(res[n]!=-1){
            return res[n];
        }
        
        res[n] = (topDownApproach(n-1) + topDownApproach(n-2))%modulo;
        
        return res[n];
    }
    
    static long topDown(int n) {
        
        //topDown approach use recursion
        
        if(n<=1){
            return n;
        }
        
        //n -> 0 to n         
        res = new long[n+1];
        Arrays.fill(res, -1);
        
        return topDownApproach(n);
    }

    static long bottomUp(int n) {
        
        //bottomUp use table
        
        //1d table, bcz of single varaible dependency n
        
        if(n<=1){
            return n;
        }
        
        res = new long[n+1];
        Arrays.fill(res, -1);
        
        res[0] = 0;
        res[1] = 1;
        
        for(int i=2;i<=n;i++){
            res[i] = (res[i-1] + res[i-2])%modulo;
        }
        
        return res[n];
    }
}
```

**Note:** Optimized Code for Bottom up

```java
 static long bottomUp(int n) {
        
    if(n<=1){
        return n;
    }
    
    long prevprev = 0L, prev = 1L, res = 0L;
    
    for(int i=2;i<=n;i++){
        res = (prevprev +prev)%modulo;
        prevprev = prev;
        prev = res;
    }
    
    return res;
}
```