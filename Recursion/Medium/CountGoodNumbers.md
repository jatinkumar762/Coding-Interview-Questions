https://leetcode.com/problems/count-good-numbers/description/

* it internally using Pow(x,n) code

```java
class Solution {
    
    long modulo = 1000000007; 

    private long calPow(long n, long p){

        long res = 1;

        while(p>0){
            if((p%2)!=0){
                res= (res*n)%modulo;
            }
            n = (n*n)%modulo;
            p = p/2;
        }

        return res;
    }


    public int countGoodNumbers(long n) {
        
        long countOf4 = n/2;
        long countOf5 = n - countOf4;
        
        return (int)((calPow(4, countOf4) * calPow(5, countOf5))%modulo);
    }
}
```