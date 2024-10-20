[Problem](https://leetcode.com/problems/sqrtx/description/)

#### Approach-1 (Basic)

1. take care of int range limit, bcz of it wrong error will come
2. if a is result then $a^2≤x<(a+1)^2$
 

```java
class Solution {
    public int mySqrt(int x) {
        
        if(x==0 || x==1)
            return x;
        
        for(int i=1;i<=(x/2);i++){
            long res1 = (long)i*i;
            long res2 = (long)(i+1)*(i+1);
            if(res1<=x && res2>x)
                return i;
        }
        return -1;
    }
}
```

#### Approach-2 (Binary Search)

```java
class Solution {
    public int mySqrt(int x) {
        
        int low = 0;
        int high = x;
        int mid = 0, result = 0;
    
        while (low <= high) {
            
            mid = low + (high-low) / 2;
            
            //type cast is necessary
            //otherwise int * int -> int (out of range issue)
            long midSquared = (long)mid * mid;
    
            if (midSquared == x) {
                return mid; // Exact square root found
            } else if (midSquared < x) {
                result = mid;
                low = mid+1; // Move the lower bound up
            } else {
                high = mid-1; // Move the upper bound down
            }
        }
        
        return result;
    }
}
```

**we can modify binary search like this also**

```java
mid = low + (high-low) / 2;
long res1 = (long)mid*mid;
long res2 =  (long)(mid+1)*(mid+1);

if (res1 <= x && res2>x) {
    return mid; // Exact square root found
} else if (res1 < x) {
    result = mid;
    low = mid+1; // Move the lower bound up
} else {
    high = mid-1; // Move the upper bound down
}
```