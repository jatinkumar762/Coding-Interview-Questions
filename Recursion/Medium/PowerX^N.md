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

#### Efficient Recursive Solution

```java
class Solution {
    public double myPow(double x, int n) {
        
        if(n==0)
            return 1;
        
        if(n==1)
            return x;
        
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        
        return ((n%2)==0)? myPow(x*x, n/2) : x * myPow(x*x, n/2);
        
    }
}
```

#### Efficient Solution

```java
class Solution {

    private boolean negative;

    public double myPow(double x, int n) {
        
        //recursion will give stack overflow error

        if(n==0)
            return 1;
        
        double result = 1;
        
        negative = n<0?true:false;
        
        /*
          integer overflow can happen
          when Integer.MIN_VALUE;
          n = Math.abs(n);
          x = 2.00000
          n = -2147483648, Integer.MIN_VALUE
        */

        long N = (long)(n);
        if(negative){
            N  = -1*N;
        }

        while(N>0){
            if((N&1)!=0){
                result*=x;
            }
            x=x*x;
            N=N/2;
        }
        return negative ? (1/result):result;
    }
}
```

