https://leetcode.com/problems/powx-n/

#### Time Limit Exceeded Solution

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

x = 0.00001
n = 2147483647

#### Recursive Solution - TLE

```java
class Solution {

    private double calPower(double x, int n){
        
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n==2)
            return x*x;

        
        return calPower(x, (n/2)) * calPower(x, n - (n/2));
    }

    public double myPow(double x, int n) {
        
        //recursion will give stack overflow error

        if(n==0)
            return 1;

        double result = calPower(x, Math.abs(n));

        return n>0 ? result : (1/result);
    }
}
```