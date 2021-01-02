[Problem Link](https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/)

```java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}

class Solution
{
    int res[];
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    res=new int[V+1];
	    Arrays.fill(res,Integer.MAX_VALUE);
	    res[0]=0;
	    
	    for(int i=1;i<=V;i++)
	    {
	        for(int j=0;j<M;j++)
	        {
	            if(coins[j]<=i)
	            {
	                if( res[i-coins[j]]!=Integer.MAX_VALUE && res[i]>(res[i-coins[j]]+1))
	                    res[i] = res[i-coins[j]]+1;
	            }
	        }
	    }
	    return res[V]!=Integer.MAX_VALUE?res[V]:-1;
	} 
}
```