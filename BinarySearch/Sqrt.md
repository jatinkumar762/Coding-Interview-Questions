[Problem](https://leetcode.com/problems/sqrtx/description/)

#### Approach-1 (Basic)

- Note - take care of int range limit, bcz of it wrong error will come

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
