https://leetcode.com/problems/powx-n/

#### TLE Solution

```java
class Solution {

    public double myPow(double x, int n) {
        
        //recursion will give stack overflow error

        if(n==0)
            return 1;
        
        double result = x;

        for(int i=2; i<=Math.abs(n); i++){
            result *= x;
        }

        return n>0 ? result : (1/result);
    }
}
```