[Perfect Squares](https://leetcode.com/problems/perfect-squares/)

```java
class Solution {
    public int numSquares(int n) {
        if(n==1)
            return 1;
        
        int[] res = new int[n+1];
        res[0]=0;
        res[1]=1;
        
        for(int num=2;num<=n;num++) 
        {
            int min = Integer.MAX_VALUE;
            for(int r=(int)Math.sqrt(num);r>=1;r--){
                int tmp = res[num-(r*r)];
                if(min>tmp)
                    min=tmp;
            }
            res[num] = min+1;   
        }
        return res[n];
    }
}
```