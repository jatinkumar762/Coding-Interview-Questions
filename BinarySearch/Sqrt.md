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
mid = low+(high-low)/2;
```
