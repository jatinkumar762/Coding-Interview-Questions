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
11 -> 1 0 1 1
      8 4 2 1 -> (8+2+1) = 11

    7^11
        |
        7^1 * (7^2, 5)
                |
                7^2 * (7^4, 2)
                        |
                        (7^8, 1)
                        |
                        return 7^8

from above example we can see we are going right to left in bits


#### Efficient Solution

```java
class Solution {

    private boolean negative;

    public double myPow(double x, int n) {
        
        //recursion will give stack overflow error

        if(n==0)
            return 1;
        
        boolean negative = n<0?true:false;
        
        /*
          integer overflow can happen if we do n = -1 * n
          when Integer.MIN_VALUE;
          n = Math.abs(n);
          x = 2.00000
          n = -2147483648, Integer.MIN_VALUE
        */

        long N = (long)(n);
        if(negative){
            N  = -1 * N;
        }

        double result = 1;
        while (N > 0) {
            if ((N & 1) != 0) { // when N==1 or N == odd 
                result *= x;
            }
            x = x * x;
            N = N / 2;
        }
        return negative ? (1/result):result;
    }
}
```

In order to improve efficiency we will opt for Binary Exponentiation using which we can calculate $x^n$ using $O(log2(N))$ multiplications.

Basic Idea is to divide the work using binary representation of exponents
i.e. is to keep multiplying pow with x, if the bit is odd, and multiplying x with itself until we get 0
We will use very 1st example of 1st Approach i.e.

x = 7, n = 11 and pow = 1
Here, we have to calculate 7^11

Binary of n i.e. base-10 &rarr; $(11)10$ is base-2 &rarr; $(1011)2$

&rarr; Corresponding place values of each bit

| 1  |  0  |   1  |  1 | 
|------|------|------|------|
|2^3 | 2^2 | 2^1 | 2^0 |  


OR we can also write this as

&rarr; Corresponding place values of each bit

| 1  |  0  |   1  |  1 | 
|------|------|------|------|
| 8 | 4 | 2  | 1 | 

Now, $7^8 × 7^2 × 7^1 == 7^{11} as 7^{8 + 2 + 1} == 7^{11}$

**NOTE:** We have not considered $7^4$ in this case as the 4th place bit is OFF

So, 7^8 × 7^2 × 7^1 == 5764801 × 49 × 7 == 1977326743 <-- Desired Output

Now, applying logic keeping this concept in mind

