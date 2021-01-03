[Problem Link](https://practice.geeksforgeeks.org/problems/max-length-chain/1#)

```java
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}

class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}

class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
       Arrays.sort(arr,new CompareByFirst());
       int maxChain[]=new int[n];
       Arrays.fill(maxChain,1);
       
       for(int i=1;i<arr.length;i++)
       {
           for(int j=i-1;j>=0;j--)
           {
               if(arr[i].x>arr[j].y)
               {
                    if(maxChain[j]+1>maxChain[i])
                        maxChain[i]=maxChain[j]+1;
               }
           }
       }
       return Arrays.stream(maxChain).max().getAsInt();
    }
}
```